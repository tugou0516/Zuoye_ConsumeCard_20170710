package org.forten.si.bo;

import org.forten.si.dao.HibernateDao;
import org.forten.si.dto.*;
import org.forten.si.entity.Card;
import org.forten.si.entity.ConsumeHistory;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student1 on 2017/7/11.
 */
@Service("CardBo")
public class CardBo {
    @Resource
    private HibernateDao dao;

    @Transactional
    public void doSave(Card4Save card4S){
        Card card = new Card();
        BeanPropertyUtil.copy(card,card4S);
        card.setCountLes(card.getCountAll());
        card.setBalance(card.getPrice());
        dao.save(card);
    }

    @Transactional
    public RoWithPages<Card4Show> queryBy(CardQo qo){
        String countHql = "SELECT count(id) FROM Card WHERE 1=1 ";
        String hql = "SELECT new org.forten.si.dto.Card4Show(id, cardName, countLes, countAll, balance, price, customerId, customerName, customerGender, customerTel, customerBirthday, registTime, status) FROM Card WHERE 1=1 ";
        Map<String,Object> map = new HashMap<>();

        if(StringUtil.hasText(qo.getCustomerName())){
            countHql = countHql + "AND customerName LIKE :name ";
            hql = hql + "AND customerName LIKE :name ";
            map.put("name","%"+qo.getCustomerName()+"%");
        }

        hql = hql + "ORDER BY registTime DESC ";
        long count = dao.findOneBy(countHql,map);
        if(count == 0){
            return RoWithPages.EMPTY_RO;
        }
        PageInfo page = PageInfo.getInstance(qo.getPageNo(),qo.getPageSize(),count);
        List<Card4Show> list = dao.findBy(hql, map, (int)page.getFirstResultNum(), page.getPageSize());
        return new RoWithPages<>(list,page);
    }

    @Transactional
    public Message doConsume(Card4Consume card4C){
        Card card = dao.getById(card4C.getCardId(),Card.class);
        String hql = "UPDATE Card SET countLes=:countLes, balance=:balance WHERE id=:id ";
        Map<String,Object> map = new HashMap<>();
        map.put("countLes",card.getCountLes()-card4C.getCountNum());
        map.put("balance",card.getBalance()-card4C.getPrice());
        map.put("id",card4C.getCardId());
        try{
            dao.executeUpdate(hql,map);
            ConsumeHistory ch = new ConsumeHistory();
            BeanPropertyUtil.copy(ch,card4C);
            dao.save(ch);
            return new Message("消费成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Message("消费失败");
        }
    }

    @Transactional
    public List<ConsumeHis4Show> doGetConsumeHis(int cardId){
        String hql = "SELECT new org.forten.si.dto.ConsumeHis4Show(id,cardId,countNum,price,project,consumeTime) FROM ConsumeHistory WHERE cardId=:cardId ";
        Map<String,Object> map = new HashMap<>();
        map.put("cardId",cardId);
        List<ConsumeHis4Show> list = dao.findBy(hql,map);
        return list;
    }

    @Transactional
    public Message doChangeStatus(int id, String status){
        String hql = "UPDATE Card SET status=:status WHERE id=:id ";
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("id",id);
        try{
            dao.executeUpdate(hql,map);
            return new Message("状态修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Message("状态修改失败");
        }
    }

}

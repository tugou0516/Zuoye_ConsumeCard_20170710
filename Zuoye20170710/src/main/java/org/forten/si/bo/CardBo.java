package org.forten.si.bo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.forten.si.dao.HibernateDao;
import org.forten.si.dto.*;
import org.forten.si.entity.Card;
import org.forten.si.entity.ConsumeHistory;
import org.forten.utils.common.DateUtil;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
        if(StringUtil.hasText(qo.getCustomerTel())){
            countHql = countHql + "AND customerTel LIKE :tel ";
            hql = hql + "AND customerTel LIKE :tel ";
            map.put("tel","%"+qo.getCustomerTel()+"%");
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
        int a = card.getCountLes()-card4C.getCountNum();
        int b = card.getBalance()-card4C.getPrice();
        if(a<0){
            return new Message("消费失败：剩余次数不足");
        }
        if(b<0){
            return new Message("消费失败：余额不足");
        }
        map.put("countLes",a);
        map.put("balance",b);
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
        String hql = "SELECT new org.forten.si.dto.ConsumeHis4Show(id,cardId,countNum,price,project,consumeTime) FROM ConsumeHistory WHERE cardId=:cardId ORDER BY consumeTime";
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

    @Transactional
    public Message doChangeCusInfo(int id,String customerGender,String customerTel,Date customerBirthday){
        String hql = "UPDATE Card SET customerGender=:customerGender,customerTel=:customerTel,customerBirthday=:customerBirthday WHERE id=:id ";
        Map<String,Object> map = new HashMap<>();
        map.put("customerGender",customerGender);
        map.put("customerTel",customerTel);
        map.put("customerBirthday",customerBirthday);
        map.put("id",id);
        try{
            dao.executeUpdate(hql,map);
            return new Message("顾客信息修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Message("顾客信息修改失败");
        }
    }

    @Transactional
    public Workbook doExport(){
        String hql = "SELECT new org.forten.si.dto.Card4Show(id, cardName, countLes, countAll, balance, price, customerId, customerName, customerGender, customerTel, customerBirthday, registTime, status) FROM Card ORDER BY id ";
        List<Card4Show> list = dao.findBy(hql,new HashMap<>());
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("会员卡信息");
        Row rowHead = sheet.createRow(0);
        rowHead.createCell(0).setCellValue("ID");
        rowHead.createCell(1).setCellValue("卡名");
        rowHead.createCell(2).setCellValue("剩余次数");
        rowHead.createCell(3).setCellValue("总次数");
        rowHead.createCell(4).setCellValue("余额");
        rowHead.createCell(5).setCellValue("总金额");
        rowHead.createCell(6).setCellValue("持卡顾客");
        rowHead.createCell(7).setCellValue("顾客性别");
        rowHead.createCell(8).setCellValue("顾客电话");
        rowHead.createCell(9).setCellValue("顾客生日");
        rowHead.createCell(10).setCellValue("注册时间");
        rowHead.createCell(11).setCellValue("状态");

        for (Card4Show card:list) {
            Row row = sheet.createRow(sheet.getLastRowNum()+1);
            row.createCell(0).setCellValue(card.getId());
            row.createCell(1).setCellValue(card.getCardName());
            row.createCell(2).setCellValue(card.getCountLes());
            row.createCell(3).setCellValue(card.getCountAll());
            row.createCell(4).setCellValue(card.getBalance());
            row.createCell(5).setCellValue(card.getPrice());
            row.createCell(6).setCellValue(card.getCustomerName());
            row.createCell(7).setCellValue(card.getCustomerGender());
            row.createCell(8).setCellValue(card.getCustomerTel());
            row.createCell(9).setCellValue(DateUtil.convertDateToString(card.getCustomerBirthday(),"yyyy-MM-dd"));
            row.createCell(10).setCellValue(DateUtil.convertDateToString(card.getRegistTime(),"yyyy-MM-dd"));
            row.createCell(11).setCellValue(card.getStatus());
        }
        return wb;
    }

    @Transactional
    public Message doBuyCard(int id,int buyCount,int buyPrice){
        Card card = dao.getById(id,Card.class);
        String hql = "UPDATE Card SET countLes=:countLes,countAll=:countAll,balance=:balance,price=:price WHERE id=:id ";
        Map<String,Object> map = new HashMap<>();
        int newCountLes = card.getCountLes()+buyCount;
        int newCountAll = card.getCountAll()+buyCount;
        int newBalance = card.getBalance()+buyPrice;
        int newPrice = card.getPrice()+buyPrice;
        map.put("countLes",newCountLes);
        map.put("countAll",newCountAll);
        map.put("balance",newBalance);
        map.put("price",newPrice);
        map.put("id",id);
        try{
            dao.executeUpdate(hql,map);
            return new Message("会员卡续卡成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Message("会员卡续卡失败");
        }
    }

}

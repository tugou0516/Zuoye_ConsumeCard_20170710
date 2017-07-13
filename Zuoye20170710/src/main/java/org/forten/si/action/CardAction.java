package org.forten.si.action;

import org.forten.si.bo.CardBo;
import org.forten.si.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by student1 on 2017/7/11.
 */
@Controller
@RequestMapping("/")
public class CardAction {
    @Resource
    private CardBo bo;

    @RequestMapping("save")
    public @ResponseBody Message saveCard(@RequestBody Card4Save card4S){
        try{
            bo.doSave(card4S);
            return new Message("会员卡保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Message("保存失败");
        }
    }

    @RequestMapping("list")
    public @ResponseBody RoWithPages<Card4Show> queryList(@RequestBody CardQo qo){

        return bo.queryBy(qo);
    }

    @RequestMapping("consume")
    public @ResponseBody Message consume(@RequestBody Card4Consume card4C){
        return bo.doConsume(card4C);
    }

    @RequestMapping("consumeHis")
    public @ResponseBody List<ConsumeHis4Show> getConsumeHistory(int cardId){
        return bo.doGetConsumeHis(cardId);
    }

    @RequestMapping("changeStatus")
    public @ResponseBody Message changeCardStatus(int id,String status){
        return bo.doChangeStatus(id,status);
    }
}

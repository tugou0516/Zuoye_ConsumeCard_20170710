package org.forten.si.action;

import org.apache.poi.ss.usermodel.Workbook;
import org.forten.si.bo.CardBo;
import org.forten.si.dto.*;
import org.forten.utils.common.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
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

    @RequestMapping("changeCusInfo")
    public @ResponseBody Message changeCustomerInfo(int id,String customerGender,String customerTel,String customerBirthdayStr){
        Date customerBirthday = DateUtil.convertStringToDate(customerBirthdayStr,"yyyy-MM-dd");
        return bo.doChangeCusInfo(id,customerGender,customerTel,customerBirthday);
    }

    @RequestMapping("export")
    public void exportToExcel(HttpServletResponse response){
        try(OutputStream out = response.getOutputStream(); Workbook wb = bo.doExport()){
            response.setContentType("application/x-msexcel");
            response.setHeader("Content-Disposition","attachment;filename=CardInfo.xls");
            wb.write(out);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("buyCard")
    public @ResponseBody Message buyCard(int id,int buyCount,int buyPrice){
        return bo.doBuyCard(id,buyCount,buyPrice);
    }
}

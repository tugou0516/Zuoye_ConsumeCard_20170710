package java;

import org.forten.si.bo.CardBo;
import org.forten.si.dto.Card4Save;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by student1 on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/**/app-*.xml"})
public class Test4SaveCard {
    @Resource
    private CardBo bo;

    @Test
    public void testSave(){
        Card4Save c4s01 = new Card4Save("银卡",30,900,"张娟","女","13911421054", new Date());
        Card4Save c4s02 = new Card4Save("金卡",40,1000,"刘丽丽","女","15916454754", new Date());
        Card4Save c4s03 = new Card4Save("铜卡",20,800,"刘三","男","13621745014", new Date());
        Card4Save c4s04 = new Card4Save("白金卡",100,1800,"林华","男","12100254731", new Date());
        bo.doSave(c4s01);
        bo.doSave(c4s02);
        bo.doSave(c4s03);
        bo.doSave(c4s04);
    }
}

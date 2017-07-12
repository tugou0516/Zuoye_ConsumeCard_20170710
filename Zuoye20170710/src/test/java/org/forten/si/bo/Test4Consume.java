package org.forten.si.bo;

import org.forten.si.dto.Card4Consume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by student1 on 2017/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/**/app-*.xml"})
public class Test4Consume {
    @Resource
    private CardBo bo;

    @Test
    public void testConsume(){
        Card4Consume card4C = new Card4Consume(1,2,200,"烫发");
        bo.doConsume(card4C);
    }
}

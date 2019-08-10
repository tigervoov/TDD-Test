import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class pokerHandleTest {

    @Test
    public void testCheckTwoCardListValue(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker(3,"S"));
        List<Poker> secondPokers= Arrays.asList(new Poker(5,"H"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoCardListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }


}

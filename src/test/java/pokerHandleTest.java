import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class pokerHandleTest {

    @Test
    public void testCheckTwoCardListValue(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("3","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("5","H"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }

    @Test
    public void testCheckHighCardPokersList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("3","S"),new Poker("5","D"),new Poker("8","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("5","D"),new Poker("8","C"),new Poker("4","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }



}

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
    @Test
    public void testCheckPairPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("3","S"),new Poker("5","D"),new Poker("8","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("8","C"),new Poker("4","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckPairPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("8","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("8","C"),new Poker("4","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckTwoPairPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("8","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("8","C"),new Poker("8","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckTwoPairPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("4","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("8","C"),new Poker("8","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckThreeKindPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("8","C"),new Poker("8","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckThreeKindPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("3","D"),new Poker("3","C"),new Poker("8","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckStraightPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("4","S"),new Poker("A","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("J","S"),new Poker("9","D"),new Poker("10","C"),new Poker("Q","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckStraightPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("5","D"),new Poker("6","C"),new Poker("7","S"),new Poker("8","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("J","S"),new Poker("9","D"),new Poker("10","C"),new Poker("Q","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckFlushPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("K","S"),new Poker("J","S"),new Poker("7","S"),new Poker("8","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("J","S"),new Poker("9","D"),new Poker("10","C"),new Poker("Q","S"),new Poker("K","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckFlushPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("K","S"),new Poker("J","S"),new Poker("7","S"),new Poker("8","S"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("9","S"),new Poker("10","S"),new Poker("Q","S"),new Poker("A","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckFullHousePokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("4","D"),new Poker("4","C"),new Poker("7","S"),new Poker("7","H"));
        List<Poker> secondPokers= Arrays.asList(new Poker("3","S"),new Poker("9","S"),new Poker("10","S"),new Poker("Q","S"),new Poker("A","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckFullHousePokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("4","D"),new Poker("4","C"),new Poker("7","S"),new Poker("7","H"));
        List<Poker> secondPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("Q","S"),new Poker("Q","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }
    @Test
    public void testCheckFourKindPokerList(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("4","D"),new Poker("4","C"),new Poker("4","H"),new Poker("7","H"));
        List<Poker> secondPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("Q","S"),new Poker("Q","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 1 win",result);
    }
    @Test
    public void testCheckFourKindPokerListWhenSameLevel(){
        //given
        List<Poker> firstPokers= Arrays.asList(new Poker("4","S"),new Poker("4","D"),new Poker("4","C"),new Poker("4","H"),new Poker("7","H"));
        List<Poker> secondPokers= Arrays.asList(new Poker("5","S"),new Poker("5","D"),new Poker("5","C"),new Poker("5","H"),new Poker("Q","S"));
        //when
        PokerHandle pokerHandle=new PokerHandle();
        String result=pokerHandle.checkTwoPokersListValue(firstPokers,secondPokers);
        //then
        Assert.assertEquals("Player 2 win",result);
    }




}

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PokerHandle {
    private static final int HIGH_CARD=1;
    private static final int PAIR=2;
    public String checkTwoPokersListValue(List<Poker> fistPokers, List<Poker> secondPokers) {
        int levelStr1=judgePokersListLevel(fistPokers);
        int levelStr2=judgePokersListLevel(secondPokers);
        if(levelStr1>levelStr2){
            return "Player 1 win";
        }
        if(levelStr1<levelStr2){
            return "Player 2 win";
        }else {
            if(levelStr1==1&&levelStr1==1){
                return checkHighCardPokersList(fistPokers,secondPokers);
            }else {
                return null;
            }
        }
    }

    public int judgePokersListLevel(List<Poker> pokers) {
        List<Integer> pokersNumList = pokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());

        Map<Integer, Integer> pokersMap = new HashMap<>();
        for (int i = 0; i < pokersNumList.size(); i++) {
            Integer quantityValue = pokersMap.get(pokersNumList.get(i));
            pokersMap.put(pokersNumList.get(i), quantityValue == null ? 1 : quantityValue + 1);
        }
        int pairNum=0;
        for (Integer quantityValue : pokersMap.values()) {
            if(quantityValue==1){
                continue;
            }
            if(quantityValue==2){
                pairNum++;
            }
        }
        if(pairNum==0){
            return HIGH_CARD;
        }
        if(pairNum==1){
            return PAIR;
        }
        return HIGH_CARD;
    }

    private String checkHighCardPokersList(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1 = fistPokers.stream().map(item -> item.getNumber()).max((i, j) -> i.compareTo(j)).get();
        int maxNum2 = secondPokers.stream().map(item -> item.getNumber()).max((i, j) -> i.compareTo(j)).get();
        if (maxNum1 > maxNum2) {
            return "Player 1 win";
        }
        if (maxNum1 == maxNum2) {
            return "play even";
        } else {
            return "Player 2 win";
        }
    }

}

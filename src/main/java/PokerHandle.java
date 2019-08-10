import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PokerHandle {
    private static final int HIGH_CARD = 1;
    private static final int PAIR = 2;
    private static final int TWO_PAIR = 3;
    private static final int THREE_KIND = 4;


    public String checkTwoPokersListValue(List<Poker> fistPokers, List<Poker> secondPokers) {
        int level_1 = judgePokersListLevel(fistPokers);
        int level_2 = judgePokersListLevel(secondPokers);
        if (level_1 > level_2) {
            return "Player 1 win";
        }
        if (level_1 < level_2) {
            return "Player 2 win";
        } else {
            if (level_1 == HIGH_CARD && level_2 == HIGH_CARD) {
                return checkHighCardPokersList(fistPokers, secondPokers);
            }
            if (level_1 == PAIR && level_2 == PAIR) {
                return checkPairPokersListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == TWO_PAIR && level_2 == TWO_PAIR){
                return checkTwoPairPokersListWhenSameLevel(fistPokers, secondPokers);
            }
            if(level_1 == THREE_KIND && level_2 == THREE_KIND){
                return checkThreeKindPokersListWhenSameLevel(fistPokers, secondPokers);
            }
            else{
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
        int pairNum = 0;
        for (Integer quantityValue : pokersMap.values()) {
            if (quantityValue == 1) {
                continue;
            }
            if (quantityValue == 2) {
                pairNum++;
            }
            if (quantityValue == 3) {
                return THREE_KIND;
            }
        }
        if (pairNum == 0) {
            return HIGH_CARD;
        }
        if (pairNum == 1) {
            return PAIR;
        }
        if (pairNum == 2) {
            return TWO_PAIR;
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

    private String checkPairPokersListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessPokerValue(PAIR, pokersNumList_1);
        int successPokerValue_2 = getSuccessPokerValue(PAIR, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }
    private String checkTwoPairPokersListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessPokerValue(TWO_PAIR, pokersNumList_1);
        int successPokerValue_2 = getSuccessPokerValue(TWO_PAIR, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }
    private String checkThreeKindPokersListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessPokerValue(THREE_KIND, pokersNumList_1);
        int successPokerValue_2 = getSuccessPokerValue(THREE_KIND, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private int getSuccessPokerValue(int pokersListLevel, List<Integer> pokersNumList) {
        int successPoker_key = 0;
        Map<Integer, Integer> pokersMap = new HashMap<>();
        for (int i = 0; i < pokersNumList.size(); i++) {
            Integer quantityValue = pokersMap.get(pokersNumList.get(i));
            pokersMap.put(pokersNumList.get(i), quantityValue == null ? 1 : quantityValue + 1);
        }
        for (Integer key : pokersMap.keySet()) {
            if (pokersListLevel == PAIR) {
                if (pokersMap.get(key) == 2) {
                    successPoker_key = key;
                }
            }
            if(pokersListLevel ==TWO_PAIR){
                if (pokersMap.get(key) == 2) {
                    if(key>successPoker_key){
                        successPoker_key=key;
                    }
                }
            }
            if(pokersListLevel == THREE_KIND){
                if (pokersMap.get(key) == 3) {
                    successPoker_key = key;
                }
            }

        }
        return successPoker_key;
    }


}

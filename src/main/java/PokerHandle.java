import java.util.*;
import java.util.stream.Collectors;

public class PokerHandle {
    private static final int HIGH_CARD = 1;
    private static final int PAIR = 2;
    private static final int TWO_PAIR = 3;
    private static final int THREE_KIND = 4;
    private static final int STRAIGHT = 5;
    private static final int FLUSH = 6;
    private static final int FULL_HOUSE = 7;
    private static final int FOUR_KIND = 8;
    private static final int STRAIGHT_FLUSH = 9;


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
            if (level_1 == TWO_PAIR && level_2 == TWO_PAIR) {
                return checkTwoPairPokersListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == THREE_KIND && level_2 == THREE_KIND) {
                return checkThreeKindPokersListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == STRAIGHT && level_2 == STRAIGHT) {
                return checkStraightPokerListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == FLUSH && level_2 == FLUSH) {
                return checkFlushPokerListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == FULL_HOUSE && level_2 == FULL_HOUSE) {
                return checkFullHousePokerListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == FOUR_KIND && level_2 == FOUR_KIND) {
                return checkFourKindPokerListWhenSameLevel(fistPokers, secondPokers);
            }
            if (level_1 == STRAIGHT_FLUSH && level_2 == STRAIGHT_FLUSH) {
                return checkStraightFlushPokerListWhenSameLevel(fistPokers, secondPokers);
            }
            else {
                return null;
            }
        }
    }

    public int judgePokersListLevel(List<Poker> pokers) {
        if (isFlush(pokers) && isStraight(pokers)) {
            return STRAIGHT_FLUSH;
        }
        if (isFlush(pokers)) {
            return FLUSH;
        }
        if (isStraight(pokers)) {
            return STRAIGHT;
        }
        List<Integer> pokersNumList = pokers.stream().map(item -> item.getNumber()).sorted().collect(Collectors.toList());
        Map<Integer, Integer> pokersMap = new HashMap<>();
        for (int i = 0; i < pokersNumList.size(); i++) {
            Integer quantityValue = pokersMap.get(pokersNumList.get(i));
            pokersMap.put(pokersNumList.get(i), quantityValue == null ? 1 : quantityValue + 1);
        }
        int pairNum = 0;
        int threeKindNum = 0;
        int fourKindNum = 0;
        for (Integer quantityValue : pokersMap.values()) {
            if (quantityValue == 1) {
                continue;
            }
            if (quantityValue == 2) {
                pairNum++;
            }
            if (quantityValue == 3) {
                threeKindNum++;
            }
            if (quantityValue == 4) {
                fourKindNum++;
            }
        }
        if (pairNum == 0 && threeKindNum == 0 && fourKindNum == 0) {
            return HIGH_CARD;
        }
        if (pairNum == 1 && threeKindNum == 0) {
            return PAIR;
        }
        if (pairNum == 2) {
            return TWO_PAIR;
        }
        if (pairNum == 0 && threeKindNum == 1) {
            return THREE_KIND;
        }
        if (pairNum == 1 && threeKindNum == 1) {
            return FULL_HOUSE;
        }
        if (fourKindNum == 1) {
            return FOUR_KIND;
        }
        return HIGH_CARD;
    }

    private String checkHighCardPokersList(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1 = getMaxNum(fistPokers);
        int maxNum2 = getMaxNum(secondPokers);
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
        int successPokerValue_1 = getSuccessRepeatPokerValue(PAIR, pokersNumList_1);
        int successPokerValue_2 = getSuccessRepeatPokerValue(PAIR, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkTwoPairPokersListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessRepeatPokerValue(TWO_PAIR, pokersNumList_1);
        int successPokerValue_2 = getSuccessRepeatPokerValue(TWO_PAIR, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkThreeKindPokersListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessRepeatPokerValue(THREE_KIND, pokersNumList_1);
        int successPokerValue_2 = getSuccessRepeatPokerValue(THREE_KIND, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkStraightPokerListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1 = getMaxNum(fistPokers);
        int maxNum2 = getMaxNum(secondPokers);
        return maxNum1 > maxNum2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkFlushPokerListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1 = getMaxNum(fistPokers);
        int maxNum2 = getMaxNum(secondPokers);
        return maxNum1 > maxNum2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkFullHousePokerListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessRepeatPokerValue(FULL_HOUSE, pokersNumList_1);
        int successPokerValue_2 = getSuccessRepeatPokerValue(FULL_HOUSE, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkFourKindPokerListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        List<Integer> pokersNumList_1 = fistPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        List<Integer> pokersNumList_2 = secondPokers.stream().map(item -> item.getNumber()).collect(Collectors.toList());
        int successPokerValue_1 = getSuccessRepeatPokerValue(FOUR_KIND, pokersNumList_1);
        int successPokerValue_2 = getSuccessRepeatPokerValue(FOUR_KIND, pokersNumList_2);
        return successPokerValue_1 > successPokerValue_2 ? "Player 1 win" : "Player 2 win";
    }

    private String checkStraightFlushPokerListWhenSameLevel(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1 = getMaxNum(fistPokers);
        int maxNum2 = getMaxNum(secondPokers);
        return maxNum1 > maxNum2 ? "Player 1 win" : "Player 2 win";
    }

    private int getMaxNum(List<Poker> pokers) {
        return pokers.stream().map(item -> item.getNumber()).max((i, j) -> i.compareTo(j)).get();
    }


    private Boolean isStraight(List<Poker> pokers) {
        List<Integer> pokersNumList = pokers.stream().map(item -> item.getNumber()).sorted().collect(Collectors.toList());
        Set<Integer> poker = new HashSet<>();
        for (int i = 0; i < pokersNumList.size() - 1; i++) {
            int maxValue = pokersNumList.get(pokersNumList.size() - 1);
            if (pokersNumList.get(0) + pokersNumList.size() - 1 != maxValue) {
                return false;
            }
            poker.add(pokersNumList.get(i) + pokersNumList.size() - 1 - i);
        }
        return poker.size() == 1 ? true : false;
    }

    private Boolean isFlush(List<Poker> pokers) {
        List<String> pokersFeatures = pokers.stream().map(item -> item.getFeatures()).collect(Collectors.toList());
        String firstFeature = pokersFeatures.get(0);
        long num = pokersFeatures.stream().filter(item -> item.equals(firstFeature)).count();
        return num == 5 ? true : false;
    }

    private int getSuccessRepeatPokerValue(int pokersListLevel, List<Integer> pokersNumList) {
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
            if (pokersListLevel == TWO_PAIR) {
                if (pokersMap.get(key) == 2) {
                    if (key > successPoker_key) {
                        successPoker_key = key;
                    }
                }
            }
            if (pokersListLevel == THREE_KIND || pokersListLevel == FULL_HOUSE) {
                if (pokersMap.get(key) == 3) {
                    successPoker_key = key;
                }
            }
            if (pokersListLevel == FOUR_KIND) {
                if (pokersMap.get(key) == 4) {
                    successPoker_key = key;
                }
            }


        }
        return successPoker_key;
    }


}

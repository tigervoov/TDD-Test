import java.util.List;

public class PokerHandle {
    public String checkTwoPokersListValue(List<Poker> fistPokers, List<Poker> secondPokers) {
        int maxNum1=fistPokers.stream().map(item->item.getNumber()).max((i,j)->i.compareTo(j)).get();
        int maxNum2=secondPokers.stream().map(item->item.getNumber()).max((i,j)->i.compareTo(j)).get();
        if (maxNum1 > maxNum2) {
            return "Player 1 win";
        }
        if (maxNum1 == maxNum2) {
            return "play even";
        }
        else{
            return "Player 2 win";
        }
    }

}

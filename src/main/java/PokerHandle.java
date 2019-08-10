import java.util.List;

public class PokerHandle {
    public String checkTwoCardListValue(List<Poker> fistPokers, List<Poker> secondPokers) {
        if (getNumber(fistPokers.get(0)) > getNumber(secondPokers.get(0))) {
            return "Player 1 win";
        }
        if (getNumber(fistPokers.get(0)) == getNumber(secondPokers.get(0))) {
            return "play even";
        }
        else{
            return "Player 2 win";
        }
    }

    public int getNumber(Poker poker) {
        return poker.getNumber();
    }
}

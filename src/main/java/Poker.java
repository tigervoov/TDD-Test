public class Poker {
    private int number;
    private String features;

    public Poker(String number, String features) {
        this.number = formatPokerValue(number);
        this.features = features;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    private int formatPokerValue(String number){
        if(number=="T"){
            return 10;
        }
        if(number=="J"){
            return 11;
        }
        if(number=="Q"){
            return 12;
        }
        if(number=="K"){
            return 13;
        }
        if(number=="A"){
            return 14;
        } else{
            return Integer.parseInt(number);
        }
    }
}

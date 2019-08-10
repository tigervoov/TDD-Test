public class Poker {
    private int number;
    private String features;

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

    public Poker(int number, String features) {
        this.number = number;
        this.features = features;
    }
}

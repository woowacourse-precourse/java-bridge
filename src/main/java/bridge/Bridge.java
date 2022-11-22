package bridge;

public enum Bridge {
    UPPER_BRIDGE("U", 1),
    LOWER_BRIDGE("D", 0);

    private final String bridgeWay;
    private final int randomNumber;

    Bridge(String bridgeWay, int randomNumber){
        this.bridgeWay = bridgeWay;
        this.randomNumber = randomNumber;
    }

    public String getBridgeWay(){
        return this.bridgeWay;
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }
}

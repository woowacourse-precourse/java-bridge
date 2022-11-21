package bridge.model.validation;

public class BridgeSize {
    public static final int MAX = 20;
    public static final int MIN = 3;
    private final int bridgeSize;

    public BridgeSize(int bridgeSize){
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeSize(){
        return bridgeSize;
    }

    public static int checkRange(int input){
        if(input < MIN || input > MAX){
            throw new IllegalArgumentException("");
        }

        return input;
    }


}


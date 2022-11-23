package bridge.model;

public class BridgeCalculator {
    private static final int NUM_PLUS = 1;
    private static final int INIT_LOCATION = -1;
    private static final int INIT_RETRY_COUNT = 1;

    public int countNum(int num){
        return num + NUM_PLUS;
    }

    public int getInitLocation(){
        return INIT_LOCATION;
    }

    public int getInitRetryCount(){
        return INIT_RETRY_COUNT;
    }
}

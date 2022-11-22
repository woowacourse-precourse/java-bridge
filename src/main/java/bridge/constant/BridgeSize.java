package bridge.constant;

public enum BridgeSize {
    BRIDGE_SIZE(3,20);

    private int minimumSize;
    private int maximumSize;
    BridgeSize(int minimumSize,int maximumSize){
        this.minimumSize = minimumSize;
        this.maximumSize = maximumSize;
    }
    public int getMinimumSize(){
        return minimumSize;
    }
    public int getMaximumSize(){
        return maximumSize;
    }
}

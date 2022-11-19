package Constant;

public enum BridgeConstant {
    MIN_SIZE(3),
    MAX_SIZE(20);
    private final int val;
    BridgeConstant(int num){
        this.val = num;
    }
    public int getVal(){
        return val;
    }
}

package Constant;

public enum BridgeConstant {
    INPUT_RANGE(3,20);
    private final int min;
    private final int max;
    private final String invalidRange;
    BridgeConstant(int min, int max){
        this.min = min;
        this.max = max;
        this.invalidRange = String.format("[ERROR]다리 길이는 %d부터 %d사이의 숫자여야 합니다.",min,max);
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
    public String  getErrorMsg(){
        return invalidRange;
    }
}

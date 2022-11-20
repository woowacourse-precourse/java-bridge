package bridge;

public enum BridgeCondition {
    UP("U", "O", "X", 1),
    DOWN("D", "O", "X", 0);

    private final String dataValue;
    private final String successPrint;
    private final String failPrint;
    private final int inputValue;

    BridgeCondition(String dataValue, String successPrint, String failPrint, int inputValue){
        this.dataValue = dataValue;
        this.successPrint = successPrint;
        this.failPrint = failPrint;
        this.inputValue = inputValue;
    }

    public String getDataValue(){
        return new String(dataValue);
    }

    public String getSuccessPrint(){
        return new String(successPrint);
    }

    public String getFailPrint(){
        return new String(failPrint);
    }

    public int getInputValue(){
        return inputValue;
    }

    static public BridgeCondition findByInput(int inputValue) throws IllegalArgumentException{
        for(BridgeCondition bridgeCondition : values()){
            if(bridgeCondition.getInputValue() == inputValue) {
                return bridgeCondition;
            }
        }

        throw new IllegalArgumentException("[ERROR] 입력된 다리의 상태가 올바르지 않습니다.");
    }

    static public BridgeCondition findByDataValue(String dataValue) throws IllegalArgumentException{
        for(BridgeCondition bridgeCondition : values()){
            if(bridgeCondition.getDataValue().equals(dataValue)){
                return bridgeCondition;
            }
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸의 값이 잘못되었습니다.");
    }
}

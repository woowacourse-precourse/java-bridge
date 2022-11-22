package bridge.bridgemaker;

public enum BridgeMakerEnum {
    U(1),
    D(0);
    private int number;
    BridgeMakerEnum(int i) {
        this.number = i;
    }
    public static String checkBridge(int number){
        String result = null;
        for (BridgeMakerEnum value : BridgeMakerEnum.values()) {
            if(number == value.number){
                result = value.name();
            }
        }
        return result;
    }
}

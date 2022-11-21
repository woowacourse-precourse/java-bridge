package bridge.enums;

public enum BridgeType {
    UPPER("U", 1), LOWER("D", 0);

    private String command;
    private int value;

    private BridgeType(String command, int value){
        this.command = command;
        this.value = value;
    }

    public String getCommand(){
        return this.command;
    }

    public int getValue(){
        return this.value;
    }
}

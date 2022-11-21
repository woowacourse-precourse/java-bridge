package bridge;

public enum MoveType {
    DOWN(0, "D"),
    UP(1, "U");
    private final int value;
    private final String strValue;
    MoveType(int value, String type) {
        this.value = value;
        this.strValue =type;
    }
    public String getStrValue(){
        return strValue;
    }
}

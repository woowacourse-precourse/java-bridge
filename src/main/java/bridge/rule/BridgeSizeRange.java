package bridge.rule;

public enum BridgeSizeRange {

    START(3),
    END(20);

    private final int size;

    BridgeSizeRange(int size){
        this.size = size;
    }

    public static boolean isBridgeSizeOutOfRange(int number){
        return number < START.size || number > END.size;
    }
}

package bridge.constant;

public enum BridgeMakerNumberStatus {
    ZERO(0,"D"),
    ONE(1,"U");

    private final int number;
    private final String alpha;

    BridgeMakerNumberStatus(int number, String alpha){
        this.number = number;
        this.alpha = alpha;
    }

    public static String getAlpha(int number) {
        if (number == ZERO.number){
            return ZERO.alpha;
        }
        return ONE.alpha;
    }
}

package bridge.model;

public enum BridgeSizeRule {
    START(3),
    END(20),
    ;

    private final int size;

    BridgeSizeRule(int size) {
        this.size = size;
    }

    public static void validateRule(int inputSize) {
        if (inputSize < BridgeSizeRule.START.size || BridgeSizeRule.END.size < inputSize) {
            throw new IllegalArgumentException(
                    String.format("다리의 길이는 %d부터 %d사이의 숫자여야 합니다.",
                            BridgeSizeRule.START.size,
                            BridgeSizeRule.END.size));
        }
    }
}

package bridge.BridgeGenerator;

import java.util.Arrays;

public enum BridgeRandomType {
    UP(1, "U"), DOWN(0, "D");

    private final int num;
    private final String enableMove;

    BridgeRandomType(int num, String enableMove) {
        this.num = num;
        this.enableMove = enableMove;
    }

    public int getNum() {
        return num;
    }

    public String getEnableMove() {
        return enableMove;
    }

    public static BridgeRandomType findEnableMove(int num) {
        return Arrays.stream(values()).filter(b -> b.getNum() == num).findAny().orElse(null);
    }
}

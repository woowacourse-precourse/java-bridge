package bridge.domain;

import java.util.Arrays;

public enum BridgeCell {

    UP("U", 1),
    DOWN("D", 0),
    ;

    private final String signature;
    private final int number;


    BridgeCell(String signature, int number) {
        this.signature = signature;
        this.number = number;
    }

    public static BridgeCell getBridgeCell(int number) {
        return Arrays.stream(BridgeCell.values())
                .filter(cell -> cell.number == number)
                .findAny()
                .orElseThrow(() -> Config.EXCEPTION);
    }

    public static BridgeCell getBridgeCell(String signature) {
        return Arrays.stream(BridgeCell.values())
                .filter(cell -> cell.signature.equals(signature))
                .findAny()
                .orElseThrow(() -> Config.EXCEPTION);
    }

    public String getSignature() {
        return signature;
    }

    public int getNumber() {
        return number;
    }

    static class Config {
        private static final IllegalArgumentException EXCEPTION = new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
    }
}

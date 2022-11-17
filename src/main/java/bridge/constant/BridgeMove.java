package bridge.constant;

import java.util.Arrays;

public enum BridgeMove {

    DOWN(0, "D"),
    UP(1, "U"),
    MISS(-1, "M"),
    ;

    private final int symbolicNumber;
    private final String firstLetter;

    BridgeMove(int symbolicNumber, String firstLetter) {
        this.symbolicNumber = symbolicNumber;
        this.firstLetter = firstLetter;
    }

    public static BridgeMove findByInput(String input) {
        return Arrays.stream(BridgeMove.values())
                .filter(bridgeMove -> bridgeMove.equalFirstLetterWithInput(input))
                .findAny()
                .orElse(MISS);
    }

    public boolean equalFirstLetterWithInput(String input) {
        return firstLetter.equals(input);
    }

    public boolean isMiss() {
        return this == MISS;
    }

    public int getSymbolicNumber() {
        return symbolicNumber;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}

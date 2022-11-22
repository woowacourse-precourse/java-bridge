package bridge.type;

import bridge.exception.ErrorCode;
import java.util.Arrays;

public enum BridgeSpaceStatus {
    UP("U", 1),
    DOWN("D", 0);
    private final String letter;
    private final int number;

    BridgeSpaceStatus(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    public static BridgeSpaceStatus findByNumber(final int number) {
        return Arrays.stream(BridgeSpaceStatus.values())
            .filter(bridgeInformation -> bridgeInformation.number == number)
            .findAny()
            .orElseThrow(
                () -> new IllegalArgumentException(ErrorCode.INVALID_SIGNATURE_NUMBER.getMessage())
            );
    }

    public static BridgeSpaceStatus findByLetter(final String letter) {
        return Arrays.stream(BridgeSpaceStatus.values())
            .filter(bridgeInformation -> bridgeInformation.letter.equals(letter))
            .findAny()
            .orElseThrow(
                () -> new IllegalArgumentException(ErrorCode.INVALID_SIGNATURE_LETTER.getMessage())
            );
    }
}

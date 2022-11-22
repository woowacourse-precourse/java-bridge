package bridge.domain;

import java.util.Arrays;

public enum MoveDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private int binaryCode;
    private String alphabetCode;

    MoveDirection(int binaryCode, String alphabetCode) {
        this.binaryCode = binaryCode;
        this.alphabetCode = alphabetCode;
    }

    public static MoveDirection findByBinaryCode(int binaryCode) {
        return Arrays.stream(MoveDirection.values())
                .filter(moveDirection -> moveDirection.hasBinaryCode(binaryCode))
                .findAny()
                .orElseThrow(() -> {throw new IllegalArgumentException();});
    }

    public boolean hasBinaryCode(int binaryCode) {
        return this.binaryCode == binaryCode;
    }

    public String getAlphabetCode() {
        return this.alphabetCode;
    }
}

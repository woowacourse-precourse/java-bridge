package bridge.constant;

import java.util.Arrays;

public enum BlockNumber {
    UPPER(1, "U"),
    LOWER(0, "D"),
    NONE(-1, "NONE");

    private int number;
    private String block;

    BlockNumber(int number, String block) {
        this.number = number;
        this.block = block;
    }

    public static BlockNumber findByNumber(int number) {
        return Arrays.stream(BlockNumber.values())
                .filter(blockNumber -> blockNumber.isSameNumber(number))
                .findAny()
                .orElse(NONE);
    }

    public boolean isSameNumber(int number) {
        if (this.number == number) {
            return true;
        }
        return false;
    }

    public String getBlock() {
        return block;
    }
}

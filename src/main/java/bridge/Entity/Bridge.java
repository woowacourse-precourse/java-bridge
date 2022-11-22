package bridge.Entity;

import java.util.Arrays;

public enum Bridge {
    UP("U", 1),
    DOWN("D", 0),
    WRONG("", -1);

    private final String letter;
    private final int number;

    Bridge(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    public static Bridge find(int number) {
        return Arrays.stream(values())
                .filter(val -> val.number == number)
                .findFirst()
                .orElse(WRONG);
    }
}

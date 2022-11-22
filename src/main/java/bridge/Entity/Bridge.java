package bridge.Entity;

import java.util.Arrays;

public enum Bridge {
    UP("U", 0),
    DOWN("D", 1),
    WRONG("X", -1),
    NOTHING(" ", -2);

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
                .orElse(NOTHING);
    }

    public static Bridge fintByLetter(String input) {
        return Arrays.stream(values())
                .filter(val -> val.letter.equals(input))
                .findFirst()
                .orElse(NOTHING);
    }

    public static Bridge compareTo(String bridge, String user){
        if (!bridge.equals(user))
            return WRONG;
        return Arrays.stream(values())
                .filter(val -> val.letter.equals(bridge))
                .findFirst()
                .orElse(NOTHING);
    }
}

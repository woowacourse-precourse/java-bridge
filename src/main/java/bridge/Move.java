package bridge;

import java.util.regex.Pattern;

public enum Move {
    D(1, "D"),
    U(0, "U");

    private final int order;
    private final String location;

    private Move(int order, String location) {
        this.order = order;
        this.location = location;
    }

    public static Move createMove(String move) {
        isValidMoving(move);
        return Move.valueOf(move);
    }

    private static void isValidMoving(String userInput) {
        if (!Pattern.matches("^[DU]{1}$", userInput)) {
            throw new IllegalArgumentException("[ERROR] D 혹은 U 한 문자를 입력해야 합니다");
        }
    }

    public String getLocation() {
        return location;
    }

    public int getOrder() {
        return order;
    }
}

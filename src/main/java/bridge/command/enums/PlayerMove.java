package bridge.command.enums;

import java.util.Arrays;

public enum PlayerMove {
    U("U", 1),
    D("D", 0);

    private final String move;
    private final Integer number;

    private static final String UNKNOWN = "unknown";

    PlayerMove(String move, Integer number) {
        this.move = move;
        this.number = number;
    }

    @Override
    public String toString() {
        return move;
    }

    public static String findMove(Integer number) {
        return Arrays.stream(values())
            .filter(playerMove -> playerMove.number.equals(number))
            .findFirst()
            .map(PlayerMove::toString)
            .orElse(UNKNOWN);
    }

    public static boolean isInPlayerMove(String input) {
        return Arrays.stream(values())
            .anyMatch(playerMove -> playerMove.move.equals(input));
    }
}

package bridge;

import java.util.Map;

public enum Move {
    UP("U"),
    DOWN("D")
    ;

    private final String select;

    Move(String select) {
        this.select = select;
    }

    private static final Map<String, Move> CONVERTER = Map.of(
            "U", UP,
            "D", DOWN
    );

    public static Move of(String select) {
        Move move = CONVERTER.get(select);

        if (move == null) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 만 입력할 수 있습니다.");
        }

        return move;
    }
}

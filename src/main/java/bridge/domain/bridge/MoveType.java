package bridge.domain.bridge;

public enum MoveType {
    UP("U"),
    DOWN("D");

    private final String value;

    MoveType(String value) {
        this.value = value;
    }

    public static MoveType create(String moveInput) {
        validMoveType(moveInput);
        if (moveInput.equals("U")) {
            return MoveType.UP;
        }
        return MoveType.DOWN;
    }

    private static void validMoveType(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 를 입력해야 합니다.");
        }
    }

    public boolean isSame(String position) {
        return value.equals(position);
    }
}

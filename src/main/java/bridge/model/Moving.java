package bridge.model;

public class Moving {
    private final String moving;

    public Moving(String moving) {

        validateNotNull(moving);
        validateUOrD(moving);
        this.moving = moving;
    }

    private void validateNotNull(String moving) {
        if (moving == null || "".equals(moving)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D로만 입력해주세요.");
        }
    }

    private void validateUOrD(String moving) {
        if (!("U".equals(moving) || "D".equals(moving))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D로만 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return moving;
    }
}

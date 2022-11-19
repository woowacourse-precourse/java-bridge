package bridge;

public class Moving {

    private final String moving;
    private static final String WRONG_MOVING = "[ERROR] 이동할 칸은 U(위) 또는 D(아래)여야 합니다.";

    public Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    private void validateMoving(String moving) {
        if (!(moving == "U" || moving == "D"))
            throw new IllegalArgumentException(WRONG_MOVING);
    }
}

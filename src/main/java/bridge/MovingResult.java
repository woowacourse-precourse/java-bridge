package bridge;

public class MovingResult {

    private final String moving;
    private final Result result;

    public MovingResult(String moving, Result result) {
        this.moving = moving;
        this.result = result;
    }

    public static MovingResult of(String moving, Result result) {
        return new MovingResult(moving, result);
    }

    public boolean isFail() {
        return result.isFail();
    }

    public boolean isSuccess() {
        return result.isSuccess();
    }

    public boolean isUpSide() {
        return moving.equals("U");
    }

    public boolean isDownSide() {
        return moving.equals("D");
    }
}

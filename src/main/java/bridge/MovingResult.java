package bridge;

public class MovingResult {

    private final Moving moving;
    private final Result result;

    public MovingResult(Moving moving, Result result) {
        this.moving = moving;
        this.result = result;
    }

    public static MovingResult of(Moving moving, Result result) {
        return new MovingResult(moving, result);
    }

    public boolean isFail() {
        return result.isFail();
    }

    public boolean isSuccess() {
        return result.isSuccess();
    }

    public boolean isUpSide() {
        return moving.isUp();
    }

    public boolean isDownSide() {
        return moving.isDown();
    }
}

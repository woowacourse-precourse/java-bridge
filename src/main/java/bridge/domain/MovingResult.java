package bridge.domain;

public class MovingResult {

    private final String moving;
    private final String result;

    public MovingResult(String moving, String result) {
        this.moving = moving;
        this.result = result;
    }

    public String getMoving() {
        return moving;
    }

    public String getResult() {
        return result;
    }

    public boolean isSuccess() {
        return result.equals("O");
    }

}

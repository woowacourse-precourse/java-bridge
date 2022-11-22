package bridge;

public class Bridge {
    private final String myMovingPosition;
    private final boolean correctBridge;

    public Bridge(String answerPosition, String myMovingPosition) {
        this.myMovingPosition = myMovingPosition;
        this.correctBridge = answerPosition.equals(myMovingPosition);
    }

    public boolean isCorrectBridge() {
        return correctBridge;
    }

    public String getMyMovingPosition() {
        return myMovingPosition;
    }
}

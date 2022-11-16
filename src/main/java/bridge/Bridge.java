package bridge;

public class Bridge {
    private final String answerPosition;
    private final String myMovingPostion;
    private final boolean correctBridge;

    public Bridge(String answerPosition, String myMovingPostion) {
        this.answerPosition = answerPosition;
        this.myMovingPostion = myMovingPostion;
        this.correctBridge = answerPosition.equals(myMovingPostion);
    }

    public boolean isCorrectBridge() {
        return correctBridge;
    }

    public String getAnswerPosition() {
        return answerPosition;
    }
}

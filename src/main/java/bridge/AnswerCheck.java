package bridge;

public class AnswerCheck {
    public static boolean isNotCorrect(String movingInput) {
        boolean isNotCorrect = Application.movingInputs.get(Application.turn).equals(movingInput);
        return isNotCorrect;
    }
}

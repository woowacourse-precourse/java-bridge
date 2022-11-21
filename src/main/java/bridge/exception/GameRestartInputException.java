package bridge.exception;

public class GameRestartInputException {

    private static final String USER_RESTART = "R";
    private static final String USER_QUIT = "Q";

    public boolean isInputValid(String userInput) {
        boolean isValid = true;
        try {
            inputOnlyConsistOfRQ(userInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            isValid = false;
        } finally {
            return isValid;
        }
    }

    private void inputOnlyConsistOfRQ(String userInput) {
        if (!userInput.equals(USER_RESTART) && !userInput.equals(USER_QUIT))
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부 응답은 R, Q 중 하나여야 합니다");
    }
}

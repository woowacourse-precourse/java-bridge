package bridge.exception;

public class MoveInputException {

    private static final String USER_UP = "U";
    private static final String USER_DOWN = "D";

    public boolean isInputValid(String input) {
        boolean isValid = true;
        try {
            inputOnlyConsistOfUD(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            isValid = false;
        } finally {
            return isValid;
        }
    }

    public void inputOnlyConsistOfUD(String input) {
        if (!input.equals(USER_UP) && !input.equals(USER_DOWN)) {
            throw new IllegalArgumentException("[ERROR] 이동 칸 입력은 U, D중 하나여야 합니다.");
        }
    }
}

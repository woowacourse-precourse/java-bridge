package bridge.validation;

public class MovingValidation {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final String NOT_U_OR_D_ERROR_MESSAGE = "U 또는 D만 입력해주세요!";

    public void validate(String moving) {
        validateUOrD(moving);
    }

    public void validateUOrD(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_U_OR_D_ERROR_MESSAGE);
        }
    }

}

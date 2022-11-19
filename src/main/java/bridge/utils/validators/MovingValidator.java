package bridge.utils.validators;

public class MovingValidator {

    String moving;

    public MovingValidator(String moving) {
        this.moving = moving;
        validate();
    }

    private void validate() {
        validateInputNonBlank();
        validateInputValue();
    }

    private void validateInputNonBlank() {
        if (moving.equals("")) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private void validateInputValue() {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 대문자 U 또는 대문자 D를 입력해야 합니다.");
        }
    }
}

package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class Validation {

    enum InputType {
        MOVINGCOMMAND(2),
        GAMECOMMAND(2),
        BRIDGELENGTH(3);

        private final int lengthLimit;
        InputType(int limitLength) { this.lengthLimit = limitLength; }
    }

    private final static int LOWERBOUND = 3;
    private final static int UPPERBOUND = 20;

    /**
     * Validation 메소드의 생성자, 호출될 때 전달 받은 inputType에 따라 validate함
     */
    public Validation(String lineInput, InputType inputType) {
        checkLengthLimit(lineInput, inputType);
        if (inputType == InputType.BRIDGELENGTH) {
            validateBridgeSize(lineInput);
            return;
        }
        validateCode(lineInput, inputType);
    }

    private void checkLengthLimit(String lineInput, InputType inputType) {
        if (lineInput.length() <= inputType.lengthLimit) return;
        if (inputType == InputType.BRIDGELENGTH)
            throw new IllegalArgumentException("[ERROR] 한 글자 또는 두 글자만 입력해주세요.");
        throw new IllegalArgumentException("[ERROR] 한 글자만 입력해주세요.");
    }

    private void validateBridgeSize(String lineInput) {
        isInputNumber(lineInput);
        isTenthsPlaceZero(lineInput);
        isInValidRange(lineInput);
    }

    private void isInputNumber(String lineInput) {
        for (int index = 0; index < lineInput.length(); index++) {
            if (lineInput.charAt(index) < '0' || lineInput.charAt(index) > '9')
                throw new IllegalArgumentException("[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.");
        }
    }

    private void isTenthsPlaceZero(String lineInput) {
        if (lineInput.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 십의 자리가 0일 수 없습니다.");
    }

    private void isInValidRange(String lineInput) {
        int number = Integer.parseInt(lineInput);
        if (number < LOWERBOUND || number > UPPERBOUND)
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수를 입력해주세요.",
                            LOWERBOUND, UPPERBOUND));
    }

    private void validateCode(String lineInput, InputType inputType) {
        String correctInput = getCorrectInput(inputType);
        if (correctInput.contains(lineInput)) return;
        throw new IllegalArgumentException(
                String.format("[ERROR] %c 또는 %c를 입력해주세요.",
                        correctInput.charAt(0), correctInput.charAt(1)));
    }

    private String getCorrectInput(InputType inputType) {
        if (inputType == InputType.GAMECOMMAND) return "RQ";
        return "UD";
    }
}
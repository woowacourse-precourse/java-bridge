package bridge;

/**
 * 사용자 입력값의 예외 해당 여부를 확인하는 클래스
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

    public Validation(String lineInput, InputType inputType) {
        isNoLineFound(lineInput);
        checkLengthLimit(lineInput, inputType);
        if (inputType == InputType.BRIDGELENGTH) {
            validateBridgeSize(lineInput);
            return;
        }
        validateCode(lineInput, inputType);
    }

    private void isNoLineFound(String lineInput) {
        if (lineInput.equals(""))
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
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

    /**
     * 숫자 외 다른 입력이 주어졌는지 확인하는 메소드(다리 길이 입력: 예외 2)
     */
    private void isInputNumber(String lineInput) {
        for (int index = 0; index < lineInput.length(); index++) {
            if (lineInput.charAt(index) < '0' || lineInput.charAt(index) > '9')
                throw new IllegalArgumentException("[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.");
        }
    }

    /**
     * 십의 자리에 0이 있는지 확인하는 메소드(다리 길이 입력: 예외 3)
     */
    private void isTenthsPlaceZero(String lineInput) {
        if (lineInput.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 십의 자리가 0일 수 없습니다.");
    }

    /**
     * 입력된 자연수가 3 미만이거나 20을 초과하는지 확인하는 메소드(다리 길이 입력: 예외 4)
     */
    private void isInValidRange(String lineInput) {
        int number = Integer.parseInt(lineInput);
        if (number < LOWERBOUND || number > UPPERBOUND)
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수를 입력해주세요.",
                            LOWERBOUND, UPPERBOUND));
    }

    /**
     * 입력이 이동 명령 또는 재시작/종료 코드에 부합하는 입력인지 확인하는 메소드(코드 입력: 예외 2)
     */
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

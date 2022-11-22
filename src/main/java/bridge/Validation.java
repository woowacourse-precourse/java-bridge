package bridge;

/**
 * 사용자 입력값의 예외 해당 여부를 확인하는 클래스
 */
public class Validation {

    enum InputType {
        MOVINGCOMMAND("UD"),
        GAMECOMMAND("RQ"),
        BRIDGESIZE("NONE");

        private final String correctInput;
        InputType(String correctInput) { this.correctInput = correctInput; }
    }

    private final static int LOWERBOUND = 3;
    private final static int UPPERBOUND = 20;


    public Validation(String lineInput, InputType inputType) {
        isBlankInput(lineInput);
        if (inputType == InputType.BRIDGESIZE) validateBridgeSize(lineInput);
        if (inputType == InputType.MOVINGCOMMAND) validateMovingCommand(lineInput, inputType.correctInput);
        if (inputType == InputType.GAMECOMMAND) validateGameCommand(lineInput, inputType.correctInput);
    }

    /**
     * 공통 예외: 공백으로만 이루어진 경우
     */
    private void isBlankInput(String lineInput) {
        if (lineInput.isBlank())
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
    }

    /**
     * 다리 길이 입력 예외 1, 2, 3, 4를 확인하는 메소드를 호출함
     */
    private void validateBridgeSize(String lineInput) {
        checkBridgeSizeLengthLimit(lineInput);
        isInputNumber(lineInput);
        isTenthsPlaceZero(lineInput);
        isInValidRange(lineInput);
    }

    /**
     * 이동 명령 입력 예외 1, 2를 확인하는 메소드를 호출함
     */
    private void validateMovingCommand(String lineInput, String correctInput) {
        checkCommandLengthLimit(lineInput);
        validateCode(lineInput, correctInput);
    }

    /**
     * 게임 재시작/종료 코드 입력 예외 1, 2를 확인하는 메소드를 호출함
     */
    private void validateGameCommand(String lineInput, String correctInput) {
        checkCommandLengthLimit(lineInput);
        validateCode(lineInput, correctInput);
    }

    /**
     * 다리 길이 입력 - 예외 1: 문자열 길이가 3 이상인 입력이 주어졌는지 확인하는 메소드
     */
    private void checkBridgeSizeLengthLimit(String lineInput) {
        if (lineInput.length() <= 2) return;
        throw new IllegalArgumentException("[ERROR] 한 글자 또는 두 글자만 입력해주세요.");
    }

    /**
     * 다리 길이 입력 - 예외 2: 숫자 외 다른 입력이 주어졌는지 확인하는 메소드
     */
    private void isInputNumber(String lineInput) {
        for (int index = 0; index < lineInput.length(); index++) {
            if (lineInput.charAt(index) < '0' || lineInput.charAt(index) > '9')
                throw new IllegalArgumentException("[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.");
        }
    }

    /**
     * 다리 길이 입력 - 예외 3: 십의 자리에 0이 있는지 확인하는 메소드
     */
    private void isTenthsPlaceZero(String lineInput) {
        if (lineInput.length() == 2 && lineInput.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 십의 자리가 0일 수 없습니다.");
    }

    /**
     * 다리 길이 입력 - 예외 4: 입력된 자연수가 3 미만이거나 20을 초과하는지 확인하는 메소드
     */
    private void isInValidRange(String lineInput) {
        int number = Integer.parseInt(lineInput);
        if (number < LOWERBOUND || number > UPPERBOUND)
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수를 입력해주세요.",
                            LOWERBOUND, UPPERBOUND));
    }

    /**
     * 코드 입력 - 예외 1: 입력된 문자열 길이가 2 이상인지 확인하는 메소드
     */
    private void checkCommandLengthLimit(String lineInput) {
        if (lineInput.length() == 1) return;
        throw new IllegalArgumentException("[ERROR] 한 글자만 입력해주세요.");
    }

    /**
     * 코드 입력 - 예외 2: 입력이 이동 명령 또는 재시작/종료 코드에 부합하는 입력인지 확인하는 메소드
     */
    private void validateCode(String lineInput, String correctInput) {
        if (correctInput.contains(lineInput)) return;
        throw new IllegalArgumentException(
                String.format("[ERROR] %c 또는 %c를 입력해주세요.",
                        correctInput.charAt(0), correctInput.charAt(1)));
    }
}

package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    enum InputType {
        MOVINGCOMMAND(2),
        GAMECOMMAND(2),
        BRIDGELENGTH(3);

        private int lengthLimit;
        private InputType(int limitLength) { this.lengthLimit = limitLength; }
    }

    private String lineInput;

    private void checkLengthLimit(String lineInput, int limit) {
        if (lineInput.length() > limit)
            throw new IllegalArgumentException("[ERROR] 한 글자 또는 두 글자만 입력해주세요.");
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

    private void isInValidRange(String lineInput, int lowerBound, int upperBound) {
        int number = Integer.parseInt(lineInput);
        if (number < lowerBound || number > upperBound)
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수를 입력해주세요.",
                            lowerBound, upperBound));
    }

    private void validateBridgeSize(String lineInput) {
        isTenthsPlaceZero(lineInput);
        isInputNumber(lineInput);
        isInValidRange(lineInput, 3, 20);
    }

    private void validateCode(String lineInput, InputType inputType) {
        String correctInput = "";
        if (inputType == InputType.GAMECOMMAND) correctInput = "RQ";
        if (inputType == InputType.MOVINGCOMMAND) correctInput = "UD";
        if (correctInput.contains(lineInput)) return;
        throw new IllegalArgumentException(
                String.format("[ERROR] %c 또는 %c를 입력해주세요.",
                        correctInput.charAt(0), correctInput.charAt(1)));
    }

    private void validate(String lineInput, InputType inputType) {
        checkLengthLimit(lineInput, inputType.lengthLimit);
        if(inputType == InputType.BRIDGELENGTH) {
            validateBridgeSize(lineInput);
            return;
        }
        validateCode(lineInput, inputType);
    }

    private String readInput(InputType inputType) {
        while(true) {
            String lineInput = Console.readLine();
            try {
                validate(lineInput, inputType);
                return lineInput;
            } catch(IllegalArgumentException e) {
                new OutputView(e.getMessage()).printMessage();
            }
        }
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        lineInput = readInput(InputType.BRIDGELENGTH);
        return Integer.parseInt(lineInput);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        lineInput = readInput(InputType.MOVINGCOMMAND);
        return lineInput;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        lineInput = readInput(InputType.GAMECOMMAND);
        return lineInput;
    }
}
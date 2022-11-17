package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
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
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 자연수를 입력해주세요.");
    }

    private void validate(String lineInput) {
        checkLengthLimit(lineInput, 2);
        isInputNumber(lineInput);
        isTenthsPlaceZero(lineInput);
        isInValidRange(lineInput, 3, 20);
    }
    
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
            String lineInput = Console.readLine();
            try {
                validate(lineInput);
                break;
            } catch(IllegalArgumentException e) {
                OutputView outputview = new OutputView(e.getMessage());
            }
        }
        return Integer.parseInt(lineInput);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

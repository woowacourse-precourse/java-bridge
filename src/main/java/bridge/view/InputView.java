package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static InputView instance;
    private final int BRIDGE_LENGTH_RANGE_START = 3; // 다리길이 범위 시작
    private final int BRIDGE_LENGTH_RANGE_END = 20; // 다리길이 범위 종료

    private InputView() { } // for singleton pattern

    public static InputView getInstance() {
        if(instance == null) {
            return new InputView();
        }
        return instance;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String message, String end) throws IllegalArgumentException {
        OutputView.getInstance().printMessage(message, end);
        String userInput = Console.readLine();
        return validateBridgeSize(userInput);
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

    /*
     * 사용자가 입력한 다리 길이의 유효성을 확인한다.
     * 1. 값이 입력되었는 가?
     * 2. 숫자로 변환할 수 있는 값이 입력되었는 가?
     * 3. 변환한 숫자가 3 ~ 20 범위에 포함되는 가?
     */
    public int validateBridgeSize(String userInput) throws IllegalArgumentException {
        lengthIsValid(userInput);
        isDigit(userInput);
        int bridgeLength = Integer.parseInt(userInput);
        rangeIsValid(bridgeLength);
        return bridgeLength;
    }

    private void lengthIsValid(String userInput) throws IllegalArgumentException {
        if (userInput.length() == 0 || userInput.length() > 2) {
            OutputView.getInstance().printErrorMessage("입력값의 길이가 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isDigit(String userInput) throws IllegalArgumentException {
        char[] eachDigits = userInput.toCharArray();
        for (char digit : eachDigits) {
            if (!Character.isDigit(digit)) {
                OutputView.getInstance().printErrorMessage("입력된 값이 숫자가 아닙니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void rangeIsValid(int length) throws IllegalArgumentException {
        if (length < BRIDGE_LENGTH_RANGE_START || length > BRIDGE_LENGTH_RANGE_END) {
            OutputView.getInstance().printErrorMessage("입력값은 "
                    + BRIDGE_LENGTH_RANGE_START
                    + " ~ "
                    + BRIDGE_LENGTH_RANGE_END
                    + "사이의 정수이어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}

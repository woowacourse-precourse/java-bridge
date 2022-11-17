package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String lengthInput = Console.readLine();
        checkIsNumber(lengthInput);

        int length = Integer.valueOf(lengthInput);
        checkRange(length);

        return length;
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

    private static void checkIsNumber(String lengthInput) {
        try {
            Integer.valueOf(lengthInput);
        } catch (IllegalArgumentException e) {
            String message = GameMessage.IS_ERROR;
            String contents = GameMessage.Exception.IS_NUMBER.getContents();
            OutputView.printMessage(message + contents);
            throw new IllegalArgumentException();
        }
    }

    private static void checkRange(int length) {
        boolean rangeError = (checkStartRange(length) || checkEndRange(length));

        if (rangeError) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkStartRange(int length) {
        String startValue = BridgeValue
                .Information
                .MINIMUM_LENGTH
                .getValue();

        int start = BridgeValue.stringToInt(startValue);
        if (length < start) {
            return true;
        }
        return false;
    }

    private static boolean checkEndRange(int length) {
        String endValue = BridgeValue
                .Information
                .MINIMUM_LENGTH
                .getValue();

        int end = BridgeValue.stringToInt(endValue);
        if (length > end) {
            return true;
        }
        return false;
    }

    private static void checkMoving(String move) {

    }

    private static void checkCommand(String command) {

    }
}

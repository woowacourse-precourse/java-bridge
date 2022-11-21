package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요.\n";
    private static final String INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력타입이 잘못되었습니다.\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(INPUT_SIZE_MESSAGE);
            int size = convertToInt(Console.readLine());
            return size;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readBridgeSize();
        }
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
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

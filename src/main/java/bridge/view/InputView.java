package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력타입이 잘못되었습니다.\n";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_MOVE_RANGE_ERROR_MESSAGE = "[ERROR] 이동은 U 또는 D로만 입력할 수 있습니다.\n";



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
        try {
            System.out.println(INPUT_MOVE_MESSAGE);
            String upDown = Console.readLine();
            isValidateMove(upDown);
            return upDown;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readMoving();
        }
    }

    private static void isValidateMove(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(INPUT_MOVE_RANGE_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

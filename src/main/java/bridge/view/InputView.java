package bridge.view;

import bridge.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static String inputValue() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = inputValue();

        Exception.isNumeric(input);
        Exception.checkBridgeSize(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = inputValue();

        Exception.checkMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = inputValue();

        Exception.checkRetry(input);
        return input;
    }

    public static int getBridgeSize() {
        try {
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getBridgeSize();
        }
    }

    public static String getMoving() {
        try {
            return readMoving();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getMoving();
        }
    }

    public static String getGameCommand() {
        try {
            return readGameCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getGameCommand();
        }
    }
}

package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        while (true) {
            try {
                int result = Integer.parseInt(Console.readLine());
                if (result < 3 || result > 20) {
                    OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                    throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                }
                return result;
            } catch (NumberFormatException e) {
                OutputView.String("[ERROR] 입력된 값이 정수가 아닙니다.");
                throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
            }
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while (true) {
            try {
                String string = Console.readLine().toUpperCase();
                if (!(string.equals("U") || string.equals("D"))) {
                    throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
                }
                return string;
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 유효한 값이 아닙니다.");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static Boolean readGameCommand() {
        Boolean result = null;
        while (true) {
            try {
                String string = Console.readLine().toUpperCase();
                if (!(string.equals("R") || string.equals("Q"))) {
                    throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
                }
                if (string.equals("R")) {
                    return result = true;
                }
                if (string.equals("Q")) {
                    return result = false;
                }
                return result;
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 유효한 값이 아닙니다.");
            }
        }
    }
}

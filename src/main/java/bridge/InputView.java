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
        try {
            int result = Integer.parseInt(Console.readLine());
            if (result < 1) {
                throw new IllegalArgumentException("[ERROR] 입력된 값이 1보다 작습니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String string = Console.readLine();
        string = string.toUpperCase();
        if (!(string.equals("U") || string.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
        return string;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

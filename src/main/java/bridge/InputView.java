package bridge;

import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INVAILD_INPUT_ERROR = "[ERROR] 잘못된 입력값 입니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int size = Integer.parseInt(Console.readLine());
            return size;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVAILD_INPUT_ERROR);
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

package bridge.view;

import bridge.domain.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        return Integer.parseInt(Console.readLine().trim());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static Direction readMoving() {
        return Direction.getPosition(Console.readLine().trim());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return Console.readLine().trim();
    }
}

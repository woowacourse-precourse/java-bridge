package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Constant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOOSE_MOVE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_OR_QUIT);
        return Console.readLine();
    }
}

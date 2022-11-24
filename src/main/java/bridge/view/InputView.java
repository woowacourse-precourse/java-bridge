package bridge.view;

import static bridge.Constants.INPUT_BRIDGE_SIZE;
import static bridge.Constants.INPUT_MOVING_SQUARE;
import static bridge.Constants.INPUT_RESTART_OR_TERMINATE;

import bridge.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        try {
            System.out.println(INPUT_BRIDGE_SIZE);
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_BRIDGE_SIZE_FORMAT
            );
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_SQUARE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RESTART_OR_TERMINATE);
        return Console.readLine();
    }
}

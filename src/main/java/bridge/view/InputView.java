package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MessageView.INPUT_BRIDGE_LENGTH.getMessage());
        try {
            String bridgeLength = Console.readLine();
            return Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorView.error + ErrorView.INVALID_BRIDGE_LENGTH);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MessageView.SELECT_TO_MOVE.getMessage());
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MessageView.INPUT_RETRY_OR_NOT_GAME.getMessage());
        return Console.readLine();
    }
}

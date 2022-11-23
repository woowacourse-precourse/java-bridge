package bridge.view;

import bridge.BridgeSize;
import bridge.constant.GuidanceMessage;
import bridge.GameCommand;
import bridge.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GuidanceMessage.INPUT_BRIDGE_SIZE);

        return BridgeSize.of(Console.readLine()).getSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        System.out.println(GuidanceMessage.INPUT_MOVING);

        return Moving.of(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(GuidanceMessage.INPUT_GAME_COMMAND);

        return GameCommand.of(Console.readLine());
    }
}

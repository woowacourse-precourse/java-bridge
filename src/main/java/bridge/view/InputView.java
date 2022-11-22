package bridge.view;

import bridge.Parser;
import bridge.constant.BridgeDirection;
import bridge.constant.BridgeSizeRule;
import bridge.constant.GameRetryCommand;
import bridge.constant.InputMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public void printGameStart() {
        System.out.println(InputMessage.BRIDGE_GAME_START.getMessage());
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputMessage.INPUT_BRIDGE_SIZE.getMessage());
        String input = Console.readLine();
        Integer bridgeSize = Parser.parseToInt(input);
        BridgeSizeRule.validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.INPUT_DIRECTION.getMessage());
        String input = Console.readLine();
        BridgeDirection.validateInputDirection(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.INPUT_RETRY.getMessage());
        String input = Console.readLine();
        GameRetryCommand.validateInputCommand(input);
        return input;
    }
}

package bridge.view;

import bridge.util.Constant;
import bridge.util.Message;
import bridge.util.Parser;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Parser parser = new Parser();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.START_MESSAGE);
        System.out.println(Message.INPUT_BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        return parser.parseBridgeSize(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.INPUT_CROSS_THE_BRIDGE_MESSAGE);
        String moving = Console.readLine();
        return parser.parseMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.INPUT_RESTART_OR_EXIT_MESSAGE);
        String gameCommand = Console.readLine();
        return parser.parsingGameCommand(gameCommand);
    }
}

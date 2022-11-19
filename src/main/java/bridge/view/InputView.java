package bridge.view;

import bridge.type.GuideMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(GuideMessage.INPUT_BRIDGE_LENGTH.getMessage());
        String bridgeSize = Console.readLine();
        System.out.println();
        return bridgeSize;
    }

    public String readMoving() {
        System.out.println(GuideMessage.INPUT_MOVE_DIRECTION.getMessage());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(GuideMessage.INPUT_GAME_COMMAND.getMessage());
        return Console.readLine();
    }
}

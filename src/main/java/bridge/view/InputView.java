package bridge.view;

import static bridge.utils.ViewMessage.*;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        return Console.readLine();
    }
}
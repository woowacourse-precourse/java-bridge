package bridge.view;

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.PrintMessage.*;

public class InputView {

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        new Validation().validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String moving = Console.readLine();
        new Validation().validateMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        new Validation().validateGameCommand(gameCommand);
        return gameCommand;
    }
}

package bridge.io;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    Validator validator = new Validator();

    public int readBridgeSize() {
        System.out.println();
        System.out.println(InputText.BRIDGE_SIZE.getInputText());

        String input = Console.readLine();
        validator.checkValidBridgeSize(input);

        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println();
        System.out.println(InputText.MOVING.getInputText());

        String input = Console.readLine();
        validator.checkValidMoveInput(input);

        return input;
    }

    public String readGameCommand() {
        System.out.println();
        System.out.println(InputText.GAME_COMMAND.getInputText());

        String input = Console.readLine();
        validator.checkValidRetryInput(input);

        return input;
    }
}

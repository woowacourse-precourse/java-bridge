package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeLength() {
        System.out.println(Messages.BRIDGE_LENGTH_QUESTION);
        String input = Console.readLine();
        InputValidator.validateBridgeLengthInput(input);
        return Integer.parseInt(input);
    }

    public static BridgeGameMovingInput readMoving() {
        System.out.println(Messages.MOVING_SELECTION_QUESTION);
        String input = Console.readLine();
        InputValidator.validateBridgeGameMovingInput(input);
        return BridgeGameMovingInput.fromKey(input);
    }

    public static BridgeGameCommandInput readGameCommand() {
        System.out.println(Messages.GAME_COMMAND_SELECTION_QUESTION);
        String input = Console.readLine();
        InputValidator.validateBridgeGameCommandInput(input);
        return BridgeGameCommandInput.fromKey(input);
    }
}

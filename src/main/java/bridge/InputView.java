package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        try {
            System.out.println(Constant.READ_BRIDGE_SIZE);
            String input = Console.readLine();
            return Validator.validatedBridgeSize(input);
        } catch (IllegalArgumentException bridgeSizeError) {
            System.out.println(bridgeSizeError.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            System.out.println(Constant.READ_MOVING);
            String input = Console.readLine();
            Validator.validateMoving(input);
            return input;
        } catch (IllegalArgumentException movingError) {
            System.out.println(movingError.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            System.out.println(Constant.READ_GAME_COMMAND);
            String input = Console.readLine();
            Validator.validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException gameCommandError) {
            System.out.println(gameCommandError.getMessage());
            return readGameCommand();
        }
    }
}

package bridge.view;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.PlayerChoiceValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.view.InputViewConstants.*;

public class InputView {

    public static int readBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        System.out.println(EMPTY_LINE);
        return validate(input);
    }

    private static int validate(String input) {
        try {
            BridgeSizeValidator.validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readBridgeSize();
        }
    }


    public static String readMoving() {
        System.out.println(GET_PLAYER_MOVE_MESSAGE);
        String input = Console.readLine();
        try {
            PlayerChoiceValidator.validate(input, UP_STAIR, DOWN_STAIR);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readMoving();
        }
        return input;
    }

    public static String readGameCommand() {
        System.out.println(GET_GAME_COMMAND_MESSAGE);
        String input = Console.readLine();
        try {
            PlayerChoiceValidator.validate(input, GAME_REPLAY, GAME_QUIT);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readGameCommand();
        }
        return input;
    }

}
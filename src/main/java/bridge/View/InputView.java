package bridge.View;

import bridge.Utils.InputType;
import bridge.Utils.InputValidator;
import bridge.Utils.Message;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println(Message.BRIDGE_LENTH_INPUT_MESSAGE);
        while (true) {
            try {
                return Integer.parseInt(readLine(InputType.BRIDGE));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readLine(InputType type) {
        String input = Console.readLine();
        try {
            InputValidator.getValidateInput(type,input);
            return input;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String readMoving() {
        System.out.println(Message.BRIDGE_MOVE_INPUT_MESSAGE);
        while (true) {
            try {
                return readLine(InputType.MOVE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readGameCommand() {
        System.out.println(Message.GAME_REPLAY_INPUT_MESSAGE);
        while (true) {
            try {
                return readLine(InputType.REPLAY);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

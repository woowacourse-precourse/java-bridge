package view.input;

import camp.nextstep.edu.missionutils.Console;
import bridge.validation.Validation;

public class InputView {
    private static final Validation validation = new Validation();

    public String repeat(InputMessage inputMessage) {
        while(true) {
            try {
                System.out.println("\n" + inputMessage.getMessage());
                return validation.validate(Console.readLine(), inputMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int readBridgeSize() {
        return Integer.parseInt(repeat(InputMessage.INPUT_BRIDGE_SIZE));
    }

    public String readMoving() {
        return repeat(InputMessage.INPUT_BRIDGE_MOVE);
    }

    public String readGameCommand() {
        return repeat(InputMessage.INPUT_RESTART_CODE);
    }
}
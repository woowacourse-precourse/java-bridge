package bridge.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println(UiMessage.PLEASE_INPUT_BRIDGE_SIZE.getValue());
        String input = Console.readLine();
        isDigit(input);
        return Integer.parseInt(input);
    }

    private static void isDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(48 <= c && c <= 57)) {
                throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_BRIDGE_SIZE.getValue());
            }
        }
    }

    public String readMoving() throws IllegalArgumentException {
        System.out.println(UiMessage.PLEASE_INPUT_MOVING.getValue());
        String input = Console.readLine();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_MOVING.getValue());
        }
        return input;
    }

    public String readGameCommand() {
        System.out.println(UiMessage.PLEASE_INPUT_RETRY_OR_NOT.getValue());
        String input = Console.readLine();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_RETRY_OR_NOT.getValue());
        }
        return input;
    }
}

package bridge.input;

import camp.nextstep.edu.missionutils.Console;

import static bridge.input.InputString.*;

public class InputView {
    public static int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT);
        String input = Console.readLine();
        try {
            int inputLength = Integer.parseInt(input);
            if (inputLength < 3 || inputLength > 20) {
                throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
            }
            return inputLength;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NO_NUMBER_INPUT);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

}

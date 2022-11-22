package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = convertToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    public int convertToInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.toString());
        }
        return number;
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }

}

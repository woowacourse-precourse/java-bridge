package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputViewValidator validator = new InputViewValidator();

    public int readBridgeSize() {
        return validator.checkNumberFormat(input());
    }

    public String readMoving() {
        return input();
    }

    public String readGameCommand() {
        return input();
    }

    private String input() {
        return Console.readLine();
    }
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputViewValidator validator = new InputViewValidator();

    public int readBridgeSize() {
        return validator.checkNumberFormat(input());
    }

    public String readMoving() {
        while (true) {
            try {
                return validator.checkMoving(input());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readGameCommand() {
        while (true) {
            try {
                return validator.checkCommand(input());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String input() {
        return Console.readLine();
    }
}

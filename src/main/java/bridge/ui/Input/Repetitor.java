package bridge.ui.Input;

import camp.nextstep.edu.missionutils.Console;

public abstract class Repetitor {

    private boolean validation = true;
    private String result;

    public String getResult(String notification) {
        System.out.println(notification);
        repeatInput();
        return result;
    }

    private void repeatInput() {
        while (validation) {
            receive();
        }
    }

    private void receive() {
        try {
            String userInput = Console.readLine();
            result = checkInputException(userInput);
            validation = false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    protected abstract String checkInputException(String input) throws IllegalArgumentException;
}

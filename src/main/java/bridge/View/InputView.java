package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * view내부에는 Model에 대한 코드만 있을 수 있고, Controller에 대한 코드가 있어서는 안된다!!
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println(UiMessage.PLEASE_INPUT_BRIDGE_SIZE);
        String input=Console.readLine();
        isDigit(input);
        return Integer.parseInt(input);
    }

    private static void isDigit(String input) {
        for(char c: input.toCharArray()){
            if (!(48<=c && c<=57)) {
                throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_BRIDGE_SIZE.getValue());
            }
        }
    }

    public String readMoving() throws IllegalArgumentException{
        System.out.println(UiMessage.PLEASE_INPUT_MOVING);
        String input=Console.readLine();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_MOVING.getValue());
        }
        return input;
    }

    public String readGameCommand() {
        System.out.println(UiMessage.PLEASE_INPUT_RETRY_OR_NOT);
        String input=Console.readLine();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(UiMessage.ERROR_ENTERED_RETRY_OR_NOT.getValue());
        }
        return input;
    }
}

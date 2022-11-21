package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        validateInteger(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateInteger(String userInput){
        try {
            int toInteger = Integer.parseInt(userInput);
        }
        catch (NumberFormatException exception){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        validateLength(userInput);
        return userInput;
    }

    private void validateLength(String userInput){
        if (userInput.length() != 1) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = Console.readLine();
        validateLength(userInput);
        return null;
    }
}

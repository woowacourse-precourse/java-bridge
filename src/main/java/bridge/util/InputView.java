package bridge.util;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validation validation = new Validation();
    SystemMessage systemMessage = new SystemMessage();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        systemMessage.getBridgeSize();
        String input = Console.readLine();
        systemMessage.blankLine();
        if (validation.isCheckNotDigit(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String input;
        systemMessage.getMove();
        input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String input;
        systemMessage.getCommand();
        input = Console.readLine();
        return input;
    }
}

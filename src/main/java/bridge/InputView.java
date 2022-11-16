package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.matches("\\d+") ||
                Integer.parseInt(input) < 3 ||
                Integer.parseInt(input) > 20)
            Err.WRONG_BRIDGE_LENGTH.invalid();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.equals("U") && !input.equals("D"))
            Err.WRONG_MOVE.invalid();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.equals("R") && !input.equals("Q"))
            Err.WRONG_RETRY_OR_TERMINATE.invalid();
        return input;
    }
}

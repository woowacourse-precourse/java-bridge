package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String line = Console.readLine();
        BridgeExceptionChecker.raiseExceptionIfIsNotNumber(line);
        BridgeExceptionChecker.raiseExceptionIfIsOutOfRange(line);
        return Integer.parseInt(line);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String line = Console.readLine();
        BridgeExceptionChecker.raiseExceptionIfIsNotMoving(line);
        return line;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String line = Console.readLine();
        return line;
    }
}

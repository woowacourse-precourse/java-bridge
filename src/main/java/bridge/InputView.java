package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize;
        bridgeSize = Console.readLine();
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving;
        moving = Console.readLine();
        return moving;
    }

    public String readGameCommand() {
        String gameCommand;
        gameCommand = Console.readLine();
        return gameCommand;
    }
}

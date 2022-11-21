package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSizeInput =Console.readLine();
        int bridgeSize = Integer.valueOf(bridgeSizeInput);
        return bridgeSize;
    }

    public String readMoving() {
        String direction =Console.readLine();
        // TODO: U 또는 D가 아닌 입력이 들어왔을 때의 예외 처리
        return direction;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        // TODO: Q 또는 R이 아닌 입력이 들어왔을 때의 예외 처리
        return gameCommand;
    }
}

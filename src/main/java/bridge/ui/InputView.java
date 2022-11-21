package bridge.ui;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());
        checkBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        checkMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        checkGameCommand(gameCommand);
        return gameCommand;
    }

    private void checkBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMoving(String moving) {
        if(moving != "U" || moving != "D") {
            throw new IllegalArgumentException();
        }
    }

    private void checkGameCommand(String gameCommand) {
        if(gameCommand != "R" || gameCommand != "Q") {
            throw new IllegalArgumentException();
        }
    }
}

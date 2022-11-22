package bridge.ioview;

import bridge.Validate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printInputBridgeLength();
        String bridgeSize = Console.readLine();
        Validate.checkBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printSelectDirection();
        String moveDirection = Console.readLine();
        Validate.checkMoveDirection(moveDirection);
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRestartMessage();
        String gameCode = Console.readLine();
        Validate.checkRestartCode(gameCode);
        return gameCode;
    }
}

package bridge;

import Exception.CheckException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printReadBridgeSize();
        String bridgeSize = Console.readLine();
        CheckException.bridgeSizeException(bridgeSize);
        return Integer.valueOf(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.pringReadMoving();
        String moving = Console.readLine();
        CheckException.movingException(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printReadGameCommand();
        String command = Console.readLine();
        CheckException.gameCommandException(command);
        return command;
    }
}

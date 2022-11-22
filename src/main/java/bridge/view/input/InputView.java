package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        print(InputMessage.READ_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        InputValidator.checkBridgeSizeOrElseThrowException(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        print(InputMessage.READ_MOVING_DIRECTION);
        String direction = Console.readLine();
        InputValidator.checkDirectionOrElseThrowException(direction);

        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        print(InputMessage.READ_RETRY_OR_QUIT);
        String retry = Console.readLine();
        InputValidator.checkRetryOrElseThrowException(retry);

        return retry;
    }

    private void print(String message) {
        System.out.println(message);
    }
}

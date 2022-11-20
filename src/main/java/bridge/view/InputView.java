package bridge.view;

import bridge.constants.InputMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    InputMessage inputMessage = new InputMessage();

    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printMessage(inputMessage.INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            printMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            bridgeSize = Integer.parseInt(Console.readLine());
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printMessage(inputMessage.INPUT_BRIDGE_DIRECTION);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printMessage(inputMessage.INPUT_GAME_COMMAND);
        return Console.readLine();
    }
}

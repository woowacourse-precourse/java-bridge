package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private enum ConsoleMessage {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(ConsoleMessage.INPUT_BRIDGE_SIZE.message);
        String input = Console.readLine();
        // validation
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingDirection = Console.readLine();
        return movingDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}

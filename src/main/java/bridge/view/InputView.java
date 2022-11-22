package bridge.view;

import bridge.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            Message.INPUT_BRIDGE_SIZE.print();
            try {
                String bridgeSize = Console.readLine();
                inputValidator.validateBridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            Message.INPUT_MOVING.print();
            try {
                String moving = Console.readLine();
                inputValidator.validateMoving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        while (true) {
            Message.INPUT_RESTART.print();
            try {
                String gameCommand = Console.readLine();
                inputValidator.validateGameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

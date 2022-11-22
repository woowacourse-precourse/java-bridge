package bridge.io;

import bridge.validation.InputValidator;
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
        String input = Console.readLine();

        inputValidator.validateBridgeSize(input);

        return Integer.parseInt(input);
    }

    public int readBridgeSizeUntilSuccess() {
        int bridgeSize;

        while(true) {
            try {
                bridgeSize = readBridgeSize();
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();

        inputValidator.validateMoving(moving);

        return moving;
    }

    public String readMovingSizeUntilSuccess() {
        String moving;

        while(true) {
            try {
                moving = readMoving();
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String GameCommand = Console.readLine();

        return GameCommand;
    }
}

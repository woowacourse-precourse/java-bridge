package bridge.view;

import bridge.controller.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            OutputView.requestReadBridgeSizeMessage();
            try {
                return validateBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateBridgeSize() {
        String input = Console.readLine();
        InputValidator inputValidator = new InputValidator();
        int bridgeSize = inputValidator.validatePureNumber(input);
        inputValidator.validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            OutputView.requestReadMovingMessage();
            try {
                return validateMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String validateMoving() {
        String input = Console.readLine();
        InputValidator inputValidator = new InputValidator();
        return inputValidator.validateMoving(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            OutputView.requestReadGameCommandMessage();
            try {
                return validateRestart();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private String validateRestart() {
        String input = Console.readLine();
        InputValidator inputValidator = new InputValidator();
        return inputValidator.validateRestart(input);
    }

}

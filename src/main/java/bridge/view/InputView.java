package bridge.view;

import bridge.util.InputConverter;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true){
            try {
                return this.tryReadBridgeSize();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int tryReadBridgeSize() {
        String userInput = Console.readLine();
        InputValidator.validateBridgeSize(userInput);

        return InputConverter.toInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true){
            try {
                return tryReadBridgeMove();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private String tryReadBridgeMove() {
        String userInput = Console.readLine();
        InputValidator.validateBridgeMove(userInput);

        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true){
            try {
                return tryReadGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private String tryReadGameCommand() {
        String userInput = Console.readLine();
        InputValidator.validateGameCommand(userInput);

        return userInput;
    }
}

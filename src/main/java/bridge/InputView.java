package bridge;

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
        String inputBridgeSize = "";
        try {
            inputBridgeSize = Console.readLine();
            inputValidator.bridgeSize(inputBridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMoving = "";
        try {
            inputMoving = Console.readLine();
            inputValidator.moving(inputMoving);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String inputGameCommand = "";
        try {
            inputGameCommand = Console.readLine();
            inputValidator.gameCommand(inputGameCommand);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            readGameCommand();
        }
        return inputGameCommand;
    }
}

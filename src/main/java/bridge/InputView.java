package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public int readBridgeSize() {
        String input = Console.readLine();
        inputValidator.checkBridgeInput(input);

        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        inputValidator.checkMovement(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

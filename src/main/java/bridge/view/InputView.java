package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        String input = Console.readLine();
        int size = InputValidator.changeInputToInt(input);
        InputValidator.validateBridgeSize(size);
        return size;
    }

    public static String readMoving() {
        String input = Console.readLine();
        InputValidator.validateMovementInput(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String input = Console.readLine();
        InputValidator.validateRestartInput(input);
        return input;
    }
}

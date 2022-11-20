package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(ConsoleMessage.GAME_START);
        System.out.println(ConsoleMessage.REQUEST_INPUT_BRIDGE_LENGTH);
        String input = Console.readLine();
        inputValidator.validateInputBridgeSize(input);

        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public InputType readMoving() {
        System.out.println(ConsoleMessage.REQUEST_INPUT_MOVE);
        String input = Console.readLine();
        inputValidator.validateInputMove(input);

        return getInputType(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public InputType readGameCommand() {
        System.out.println(ConsoleMessage.REQUEST_INPUT_RETRY);
        String input = Console.readLine();
        inputValidator.validateInputRetry(input);

        return getInputType(input);
    }

    private InputType getInputType(String command) {
        return InputType.getType(command.charAt(0));
    }
}

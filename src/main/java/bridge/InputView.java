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
        String input;
        do {
            input = inputBridgeSize();
        } while (input == null);

        return Integer.parseInt(input);
    }

    private String inputBridgeSize() {
        String input;
        try {
            System.out.println(ConsoleMessage.REQUEST_INPUT_BRIDGE_LENGTH);
            input = Console.readLine();
            System.out.println(); // 빈 줄 출력
            inputValidator.validateInputBridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Command readMoving() {
        String input;
        do {
            input = inputMoveCommand();
        } while (input == null);

        return getInputType(input);
    }

    private String inputMoveCommand() {
        String input;
        try {
            System.out.println(ConsoleMessage.REQUEST_INPUT_MOVE);
            input = Console.readLine();
            inputValidator.validateInputMove(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        String input;
        do {
            input = inputRetryCommand();
        } while (input == null);

        return getInputType(input);
    }

    private String inputRetryCommand() {
        String input;
        try {
            System.out.println(ConsoleMessage.REQUEST_INPUT_RETRY);
            input = Console.readLine();
            inputValidator.validateInputRetry(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return input;
    }

    private Command getInputType(String command) {
        return Command.getType(command.charAt(0));
    }
}

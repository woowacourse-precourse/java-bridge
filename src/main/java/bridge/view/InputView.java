package bridge.view;
import bridge.valid.BridgeValidator;
import bridge.valid.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return inputBridgeSize();
    }

    private static int inputBridgeSize() {
        String size = Console.readLine();

        try {
            InputValidator.validateType(size);
        } catch (IllegalArgumentException e) {
            System.out.println(OutputView.SYSTEM_MESSAGE_INPUT_BRIDGE_SIZE);
            return inputBridgeSize();
        }
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    public Integer readInitialMoving() {
        return inputInitialMoving();
    }

    private static Integer inputInitialMoving() {
        String input = Console.readLine();

        int initialMoving = Integer.parseInt(input);

        return initialMoving;
    }

    public String readMoving() {
        return inputMoving();
    }

    private static String inputMoving() {
        String moving = Console.readLine();

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return inputGameCommand();
    }

    private static String inputGameCommand() {
        String gameCommand = Console.readLine();

        return gameCommand;
    }
}
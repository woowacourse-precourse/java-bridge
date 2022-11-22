package bridge.view;

import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_MESSAGE_BRIDGE_SIZE = "[ERROR]  다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_NUMBER_FORMAT = "[ERROR] 숫자 외 문자가 입력되었습니다.";
    private static final String ERROR_MESSAGE_INPUT_MOVING = "[ERROR] U 또는 D만 입력할 수 있습니다.";
    private static final String ERROR_MESSAGE_GAME_COMMAND = "[ERROR] R 또는 Q만 입력할 수 있습니다.";

    private static final String INPUT_MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MESSAGE_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_MESSAGE_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 21;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        System.out.println(INPUT_MESSAGE_BRIDGE_SIZE);
        String input = Console.readLine();
        try {
            validateNumberFormat(input);
            bridgeSize = Integer.parseInt(input);
            validateBridgeSizeRange(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BRIDGE_SIZE);
        }
    }

    private void validateNumberFormat(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_FORMAT);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MESSAGE_MOVING);
        String inputMoving = Console.readLine();
        try {
            validateInputMoving(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputMoving = readMoving();
        }
        return inputMoving;
    }

    public void validateInputMoving(String inputMoving) {
        if (!inputMoving.equals(Command.UP) && !inputMoving.equals(Command.DOWN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_MOVING);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_MESSAGE_GAME_COMMAND);
        String inputCommand = Console.readLine();
        try {
            validateGameCommand(inputCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCommand = readMoving();
        }
        return inputCommand;
    }

    private void validateGameCommand(String inputCommand) {
        if (!inputCommand.equals(Command.RETRY) && !inputCommand.equals(Command.QUIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_GAME_COMMAND);
        }
    }
}

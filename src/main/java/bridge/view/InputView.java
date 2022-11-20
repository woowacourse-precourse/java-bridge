package bridge.view;

import bridge.exception.BridgeException;
import bridge.exception.view.BridgeSizeRangeException;
import bridge.exception.view.GameCommandInputException;
import bridge.exception.view.MoveInputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_LENGTH_MIN = 3;
    private static final int BRIDGE_LENGTH_MAX = 20;
    private static final String READ_BRIDGE_SIZE_GUIDE = "다리의 길이를 입력해주세요.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String READ_MOVING_GUIDE = "이동할 칸을 선택해주세요. (위: " + UP + ", 아래: " + DOWN + ")";
    private static final String MOVE_REGEX = String.join("|", UP, DOWN);
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String READ_GAME_COMMAND_GUIDE
            = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RETRY + ", 종료: " + QUIT + ")";
    private static final String GAME_COMMAND_REGEX = String.join("|", RETRY, QUIT);
    private static final String INPUT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_GUIDE);
        try {
            String text = Console.readLine();
            int bridgeSize = validateNumber(text);
            validateBridgeSizeRange(bridgeSize);
            System.out.println();
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readBridgeSize();
    }

    public void validateBridgeSizeRange(int size) {
        if (size < BRIDGE_LENGTH_MIN || size > BRIDGE_LENGTH_MAX) {
            throw new BridgeSizeRangeException(BRIDGE_LENGTH_MIN, BRIDGE_LENGTH_MAX);
        }
    }

    public int validateNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException exception) {
            throw new BridgeException(INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_GUIDE);
        try {
            String moving = Console.readLine();
            validateInputMoving(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readMoving();
    }

    public void validateInputMoving(String moving) {
        if (moving == null || !moving.matches(MOVE_REGEX)) {
            throw new MoveInputException(DOWN, UP);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_GUIDE);
        try {
            String gameCommand = Console.readLine();
            validateInputGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readGameCommand();
    }

    public void validateInputGameCommand(String gameCommand) {
        if (gameCommand == null || !gameCommand.matches(GAME_COMMAND_REGEX)) {
            throw new GameCommandInputException(RETRY, QUIT);
        }
    }
}

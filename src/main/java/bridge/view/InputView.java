package bridge.view;

import bridge.util.ParsingUtils;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String MOVING_TYPE_ERROR_MESSAGE = "[ERROR] 다리는 U(위) 또는 D(아래)를 입력받아 건널 수 있습니다.";
    private static final String GAME_COMMAND_TYPE_ERROR_MESSAGE = "[ERROR] 종료 명령어는 Q, 재시작 명령어는 R입니다.";
    private static final String READ_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(READ_BRIDGE_SIZE_MESSAGE);
                int bridgeSize = ParsingUtils.stringToInt(Console.readLine());
                checkNumberRange(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(READ_MOVING_MESSAGE);
                String moving = Console.readLine();
                checkMovingType(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkMovingType(String moving) {
        if (!(moving.equals(UP) || moving.equals(DOWN))) {
            throw new IllegalArgumentException(MOVING_TYPE_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println(READ_COMMAND_MESSAGE);
                String gameCommand = Console.readLine();
                checkGameCommandType(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkGameCommandType(String gameCommand) {
        if (!(gameCommand.equals(RETRY) || gameCommand.equals(QUIT))) {
            throw new IllegalArgumentException(GAME_COMMAND_TYPE_ERROR_MESSAGE);
        }
    }
}

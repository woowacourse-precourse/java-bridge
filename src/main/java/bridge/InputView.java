package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_INPUT = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_MOVING_INPUT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String BRIDGE_MOVING_ERROR = "[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.";
    private static final String GAME_COMMAND_ERROR = "[ERROR] 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";
    private static final String UP_MOVING_CHARACTER = "U";
    private static final String DOWN_MOVING_CHARACTER = "D";
    private static final String RETRY_COMMAND_CHARACTER = "R";
    private static final String QUIT_COMMAND_CHARACTER = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT);
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }

        if (!validateBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }

        return bridgeSize;
    }

    private boolean validateBridgeSize(int bridgeSize) {
        return (bridgeSize >= 3 && bridgeSize <= 20);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(BRIDGE_MOVING_INPUT);
        String moving = Console.readLine();
        if (!validateMoving(moving)) {
            throw new IllegalArgumentException(BRIDGE_MOVING_ERROR);
        }

        return moving;
    }

    private boolean validateMoving(String moving) {
        return (moving.equals(UP_MOVING_CHARACTER) || moving.equals(DOWN_MOVING_CHARACTER));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_INPUT);
        String gameCommand = Console.readLine();
        if (!validateGameCommand(gameCommand)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }

        return gameCommand;
    }

    private boolean validateGameCommand(String gameCommand) {
        return (gameCommand.equals(RETRY_COMMAND_CHARACTER) || gameCommand.equals(QUIT_COMMAND_CHARACTER));
    }
}

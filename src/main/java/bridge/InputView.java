package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_GUIDE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_GUIDE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_GUIDE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_SIZE_NOT_INTEGER_ERROR = "[ERROR] 다리 길이는 정수입니다.";
    private static final String BRIDGE_SIZE_RANGE_ERROR = "[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다.";
    private static final String MOVING_ERROR = "[ERROR] 이동 가능한 칸은 'U'(위) 또는 'D'(아래) 입니다.";
    private static final String GAME_COMMAND_ERROR = "[ERROR] 재시도 명령어는 R, 종료 명령어는 Q 입니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getInput(BRIDGE_SIZE_GUIDE);
        System.out.println();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        int size;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INTEGER_ERROR);
        }
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = getInput(MOVING_GUIDE);
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = getInput(GAME_COMMAND_GUIDE);
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input) {
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
    }

    /**
     * 안내 문구를 출력하고 사용자로부터 입력받은 문자열을 반환한다.
     *
     * @param guide 출력해줄 안내 문구
     * @return 사용자가 입력한 문자열 반환
     */
    public String getInput(String guide) {
        System.out.println(guide);
        return Console.readLine();
    }
}

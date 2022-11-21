package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

public class InputView {


    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_SPACE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_CHOICE_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INPUT_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_USER_MOVE_SPACE_ERROR_MESSAGE = "[ERROR] 사용자가 이동할 칸은 U(위 칸)과 D(아래 칸) 중 하나의 문자여야 합니다.";
    private static final String INPUT_USER_RESTART_ERROR_MESSAGE = "[ERROR] 사용자가 입력할 값은 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
            String input = Console.readLine();
            if (!input.matches("^[0-9]+$")) {
                throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_ERROR_MESSAGE);
            }
            int bridgeSize = Integer.parseInt(input);
            if (!(bridgeSize >= 3 && bridgeSize <= 20)) {
                throw new IllegalArgumentException(INPUT_BRIDGE_SIZE_ERROR_MESSAGE);
            }
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_MOVING_SPACE_MESSAGE);
            String movingSpace = Console.readLine();
            if (movingSpace.length() != 1 || !movingSpace.equals("U") && !movingSpace.equals("D")) {
                throw new IllegalArgumentException(INPUT_USER_MOVE_SPACE_ERROR_MESSAGE);
            }
            return movingSpace;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "ERROR";
        }

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(INPUT_RETRY_CHOICE_MESSAGE);
            String status = Console.readLine();
            if (status.length() != 1 || !status.equals("R") && !status.equals("Q")) {
                throw new IllegalArgumentException(INPUT_USER_RESTART_ERROR_MESSAGE);
            }
            return status;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
}

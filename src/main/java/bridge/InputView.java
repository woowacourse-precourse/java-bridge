package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_SPACE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_CHOICE_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INPUT_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_USER_MOVE_SPACE_ERROR_MESSAGE = "[ERROR] 사용자가 이동할 칸은 U(위 칸)과 D(아래 칸) 중 하나의 문자여야 합니다.";
    private static final String INPUT_USER_RESTART_ERROR_MESSAGE = "[ERROR] 사용자가 입력할 값은 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";
    private static final String CHECK_IS_NUMBER_MESSAGE = "^[0-9]+$";
    private static final String UPSIDE_MESSAGE = "U";
    private static final String DOWNSIDE_MESSAGE = "D";
    private static final String RESTART_MESSAGE = "R";
    private static final String QUIT_MESSAGE = "Q";
    private static final String RETURN_ERROR_MESSAGE = "ERROR";

    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
            String input = Console.readLine();
            if (!input.matches(CHECK_IS_NUMBER_MESSAGE)) {
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

    public String readMoving() {
        try {
            System.out.println(INPUT_MOVING_SPACE_MESSAGE);
            String movingSpace = Console.readLine();
            if (movingSpace.length() != 1 || !movingSpace.equals(UPSIDE_MESSAGE) && !movingSpace.equals(DOWNSIDE_MESSAGE)) {
                throw new IllegalArgumentException(INPUT_USER_MOVE_SPACE_ERROR_MESSAGE);
            }
            return movingSpace;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return RETURN_ERROR_MESSAGE;
        }

    }

    public String readGameCommand() {
        try {
            System.out.println(INPUT_RETRY_CHOICE_MESSAGE);
            String status = Console.readLine();
            if (status.length() != 1 || !status.equals(RESTART_MESSAGE) && !status.equals(QUIT_MESSAGE)) {
                throw new IllegalArgumentException(INPUT_USER_RESTART_ERROR_MESSAGE);
            }
            return status;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return RETURN_ERROR_MESSAGE;
        }
    }
}

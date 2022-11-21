package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String MOVING_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.";
    private static final String RETRY_QUIT_ERROR = "[ERROR] R(재시도)와 Q(종료) 중 하나의 문자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        int bridgeSize = Integer.parseInt(input);

        if (!isInRange(bridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String input = Console.readLine();

        if (!validMoving(input)) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_QUIT);
        String input = Console.readLine();

        if (!validRetryOrQuit(input)) {
            throw new IllegalArgumentException(RETRY_QUIT_ERROR);
        }

        return input;
    }

    //입력값 유효성 검사
    public static boolean isInRange(int bridgeSize) {
        return bridgeSize >= 3 && bridgeSize <= 20;
    }
    public static boolean validMoving(String input) {
        return input.equals("U") || input.equals("D");
    }

    public static boolean validRetryOrQuit(String input) {
        return input.equals("R") || input.equals("Q");
    }
}

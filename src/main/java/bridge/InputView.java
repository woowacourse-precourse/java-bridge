package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ENTER_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(ENTER_BRIDGE_LENGTH);
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(ENTER_MOVE_DIRECTION);
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(ENTER_RETRY_OR_QUIT);
        return readLine();
    }
}

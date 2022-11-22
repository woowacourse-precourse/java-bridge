package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_BRIDGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(GAME_START);
        System.out.println(INPUT_BRIDGE);
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_BRIDGE);
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_RESTART);
        return readLine();
    }
}

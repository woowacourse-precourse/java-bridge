package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String GAME_STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String CHOOSE_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String CHOOSE_RETRY_OR_QUIT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOOSE_MOVING_MESSAGE);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(CHOOSE_RETRY_OR_QUIT_MESSAGE);
        return Console.readLine();
    }

    public void printStartGame() {
        System.out.println(GAME_STARTING_MESSAGE);
    }
}

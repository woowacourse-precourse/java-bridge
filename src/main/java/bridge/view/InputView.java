package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE_ROW = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(INPUT_BRIDGE_SIZE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_MOVE_ROW);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RETRY_QUIT);
        return Console.readLine();
    }
}

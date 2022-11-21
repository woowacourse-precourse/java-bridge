package bridge.viewer;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public static int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static String readMoving() {
        System.out.println(MOVING_MESSAGE);
        return Console.readLine();
    }

    public static String readGameCommand() {
        System.out.println(GAME_COMMAND_MESSAGE);
        return Console.readLine();
    }
}

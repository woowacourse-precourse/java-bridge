package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.constant.BridgeGameInfo;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(BridgeGameInfo.INPUT_BRIDGE_SIZE.message);
        // 다리 길이 입력받기
        String userInputBridgeSize = Console.readLine();
        return Integer.parseInt(userInputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(BridgeGameInfo.SELECT_UP_DOWN.message);
        // 이동할 칸 입력받기
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(BridgeGameInfo.RESTART.message);
        // 다시 시도지 종료할지 입력받는다.
        return Console.readLine();
    }
}

package bridge.view;

import bridge.config.InputConfig;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends InputConfig {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(START_BRIDGE_GAME+"\n");
        System.out.println(INPUT_BRIDGE_LENGTH);

        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(SELECT_BRIDGE);

        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_RETRY);

        return Console.readLine();
    }
}

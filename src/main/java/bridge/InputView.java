package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final Exception exception = new Exception();

    public void startBridge() {
        System.out.println(Constants.BRIDGE_GAME_START);
    }


}

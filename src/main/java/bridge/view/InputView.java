package bridge.view;

import bridge.GameKeySet;
import bridge.controller.Input;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: " + GameKeySet.UP.getKeySet() + ", 아래: " + GameKeySet.DOWN.getKeySet() + ")";
    private static final String RESTART_OR_END_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + GameKeySet.RESTART.getKeySet() + ", 종료: " + GameKeySet.QUIT.getKeySet() + ")";

    private Input input;

    public InputView() {
        this.input = new Input();
    }

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        return input.readBridgeSize();
    }

    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);

        return input.readMoving();
    }

    public String readGameCommand() {
        System.out.println(RESTART_OR_END_INPUT_MESSAGE);

        return input.readGameCommand();
    }
}

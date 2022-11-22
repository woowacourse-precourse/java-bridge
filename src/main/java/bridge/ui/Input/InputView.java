package bridge.ui.Input;

import bridge.ui.Input.Exceptions.BridgeLength;
import bridge.ui.Input.Exceptions.GameCommand;
import bridge.ui.Input.Exceptions.Moving;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INITIATION_NOTIFICATION = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";
    private static final String MOVING_NOTIFICATION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_NOTIFICATION = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Repetitor receiver = new BridgeLength();

        int bridgeLength = Integer.parseInt(receiver.getResult(INITIATION_NOTIFICATION));

        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Repetitor receiver = new Moving();

        return receiver.getResult(MOVING_NOTIFICATION);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        Repetitor receiver = new GameCommand();

        return receiver.getResult(GAME_COMMAND_NOTIFICATION);
    }
}

package bridge.view;

import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.GameRequest;
import bridge.controller.request.MoveRequest;
import bridge.view.utils.UserInputUtils;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {

    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSizeRequest readBridgeSize() {
        String size = UserInputUtils.readLine();
        return new BridgeSizeRequest(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MoveRequest readMoving() {
        String move = UserInputUtils.readLine();
        return new MoveRequest(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameRequest readGameCommand() {
        String gameRequest = UserInputUtils.readLine();
        return new GameRequest(gameRequest);
    }
}

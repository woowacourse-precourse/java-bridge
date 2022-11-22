package bridge.view;

import bridge.controller.request.BridgeSizeRequest;
import bridge.controller.request.GameRequest;
import bridge.controller.request.MoveRequest;
import bridge.view.utils.OutputUtils;
import bridge.view.utils.UserInputUtils;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String READ_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String READ_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String READ_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private InputView() {

    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSizeRequest readBridgeSize() {
        OutputUtils.outputLine(READ_SIZE_MESSAGE);
        String size = UserInputUtils.readLine();
        return new BridgeSizeRequest(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MoveRequest readMoving() {
        OutputUtils.outputLine(READ_MOVE_MESSAGE);
        String move = UserInputUtils.readLine();
        return new MoveRequest(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameRequest readGameCommand() {
        OutputUtils.outputLine(READ_COMMAND_MESSAGE);
        String gameRequest = UserInputUtils.readLine();
        return new GameRequest(gameRequest);
    }
}

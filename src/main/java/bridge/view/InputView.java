package bridge.view;

import static bridge.constant.BridgeLength.MAX_BRIDGE_LENGTH;
import static bridge.constant.BridgeLength.MIN_BRIDGE_LENGTH;
import static bridge.constant.ErrorResponse.INVALID_BRIDGE_INPUT_TYPE;
import static bridge.constant.ErrorResponse.INVALID_BRIDGE_LENGTH;

import bridge.constant.GameCommand;
import bridge.constant.MovingDirection;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final ClientConsole clientConsole;

    public InputView(ClientConsole clientConsole) {
        this.clientConsole = clientConsole;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return validatedInputBridgeLength(clientConsole.readLine());
        } catch (NumberFormatException exception) {
            throw INVALID_BRIDGE_INPUT_TYPE.getValue();
        }
    }

    private int validatedInputBridgeLength(String bridgeLength) {
        int length = Integer.parseInt(bridgeLength);
        if (length < MIN_BRIDGE_LENGTH.getValue() || MAX_BRIDGE_LENGTH.getValue() < length) {
            throw INVALID_BRIDGE_LENGTH.getValue();
        }
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MovingDirection readMoving() {
        return MovingDirection.from(clientConsole.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        return GameCommand.from(clientConsole.readLine());
    }
}

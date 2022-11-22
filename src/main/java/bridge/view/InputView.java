package bridge.view;

import bridge.domain.BridgeValidator;
import bridge.domain.GameCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final BridgeValidator bridgeValidator;

    public InputView(BridgeValidator bridgeValidator) {
        this.bridgeValidator = bridgeValidator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        bridgeValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String direction = Console.readLine();
        bridgeValidator.validateMovingDirection(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        String gameCommand = Console.readLine();
        return GameCommand.of(gameCommand);
    }
}

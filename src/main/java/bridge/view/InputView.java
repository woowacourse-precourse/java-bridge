package bridge.view;

import bridge.domain.BridgeMovement;
import bridge.domain.GameCommand;
import bridge.util.BridgeSize;
import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String input() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = input();
        InputValidator.validateNumber(bridgeSize);
        return BridgeSize.findByRange(Integer.parseInt(bridgeSize));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeMovement readMoving() {
        String playerMove = input();
        return BridgeMovement.findByMovement(playerMove);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        String playerRetry = input();
        return GameCommand.findByCommand(playerRetry);
    }
}

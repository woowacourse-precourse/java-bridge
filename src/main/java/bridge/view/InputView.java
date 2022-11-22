package bridge.view;

import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.vo.BridgeSize.recordBridgeSize;
import static bridge.domain.vo.GameCommand.determineRetry;
import static bridge.domain.vo.Moving.recordMoving;
import static bridge.view.OutputView.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static BridgeSize readBridgeSize() {
        printBridgeSizeRequestMessage();
        String bridgeSizeInput = Console.readLine();
        BridgeSize bridgeSize = recordBridgeSize(bridgeSizeInput);
        printEnter();
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static Moving readMoving() {
        printMovingRequestMessage();
        String movingInput = Console.readLine();
        return recordMoving(movingInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameCommand readGameCommand() {
        printGameCommandRequestMessage();
        String gameCommandInput = Console.readLine();
        return determineRetry(gameCommandInput);
    }
}

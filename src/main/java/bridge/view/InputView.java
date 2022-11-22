package bridge.view;

import bridge.domain.vo.BridgeSize;

import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.vo.BridgeSize.recordBridgeSize;
import static bridge.view.OutputView.printBridgeSizeRequestMessage;
import static bridge.view.OutputView.printEnter;

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
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

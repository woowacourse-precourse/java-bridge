package bridge.ui.input;

import bridge.ui.input.dto.BridgeSize;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        PlaceHolderText placeHolderText = PlaceHolderText.READ_BRIDGE_SIZE;
        System.out.println(placeHolderText.toConsolePrintFormat());

        try {
            String bridgeSize = Console.readLine();
            return BridgeSize.from(bridgeSize);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return this.readBridgeSize();
        }
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

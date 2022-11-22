package bridge.view;

import bridge.Function;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String BridgeSizes = Console.readLine();
        if (Function.validCastingBridgeSize(BridgeSizes)) {
            int BridgeSize = Integer.parseInt(BridgeSizes);
            if (Function.validBridgeSize(BridgeSize)) {
                return BridgeSize;
            }
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String Moving = Console.readLine();
        if (Function.validMoving(Moving)) {
            return Moving;
        }
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String GameCommand = Console.readLine();
        if (Function.validGameCommand(GameCommand)) {
            return GameCommand;
        }
        return null;
    }
}

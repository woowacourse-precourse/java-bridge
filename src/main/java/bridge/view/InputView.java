package bridge.view;

import bridge.model.BridgeValidator;
import bridge.model.Direction;
import bridge.utils.InputUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        int bridgeSize = InputUtil.readNumber();
        BridgeValidator.validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = InputUtil.readAndTrim();
        return Direction.find(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


}

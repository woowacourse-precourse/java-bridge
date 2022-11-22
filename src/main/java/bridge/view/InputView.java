package bridge.view;

import static bridge.BridgeGame.BRIDGE_MIN_SIZE;
import static bridge.BridgeGame.BRIDGE_MAX_SIZE;
import static bridge.BridgeGame.BRIDGE_SIZE_ERROR;

import bridge.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
                throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
            }
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String movingIcon = Console.readLine();
        Direction.valueOfIcon(movingIcon);
        return movingIcon;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

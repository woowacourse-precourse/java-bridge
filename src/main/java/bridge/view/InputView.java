package bridge.view;

import static bridge.KeyBoardEvent.DOWN;
import static bridge.KeyBoardEvent.UP;
import static bridge.constant.NumberConstant.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.NumberConstant.MINIMUM_BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.INPUT_DIRECTION;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;

        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
        } catch (NumberFormatException exception) {
            BRIDGE_SIZE.error();
        }

        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE.getCode() || bridgeSize > MAXIMUM_BRIDGE_SIZE.getCode()) {
            BRIDGE_SIZE.error();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readDirection() {
        String direction = Console.readLine();
        validateDirection(direction);

        return direction;
    }

    private void validateDirection(String direction) {
        if (direction.equals(UP.getFirstLetter()) && direction.equals(DOWN.getFirstLetter())) {
            INPUT_DIRECTION.error();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

}

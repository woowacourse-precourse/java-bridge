package bridge.view;

import bridge.enums.ErrorMessage;
import bridge.enums.InputMessage;
import camp.nextstep.edu.missionutils.Console;

import static bridge.util.ValidationUtil.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        System.out.println();
        try {
            int bridgeSize = Integer.parseInt(input);
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH_INPUT.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String direction) {
        validateMove(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String retry) {
        validateWhetherToRetry(retry);
        return retry;
    }

    /*
        아래 메서드는 위 메서드를 오버로딩해서 테스트를 용이하게 만들었다.
        수정할 여지가 있는지 고민할 필요가 있다.
    */
    public int readBridgeSize() {
        System.out.println(InputMessage.ENTER_BRIDGE_LENGTH_MESSAGE.getMessage());
        return readBridgeSize(Console.readLine());
    }

    public String readMoving() {
        System.out.println(InputMessage.SELECT_CELL_TO_MOVE_MESSAGE.getMessage());
        return readMoving(Console.readLine());
    }

    public String readGameCommand() {
        System.out.println(InputMessage.ENTER_WHETHER_TO_RETRY_GAME_MESSAGE.getMessage());
        return readGameCommand(Console.readLine());
    }
}

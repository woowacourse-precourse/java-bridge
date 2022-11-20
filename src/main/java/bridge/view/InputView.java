package bridge.view;

import bridge.enums.ErrorMessage;
import bridge.enums.InputMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputMessage.ENTER_BRIDGE_LENGTH_MESSAGE.getMessage());
        try {
            int bridgeSize = Integer.valueOf(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH_INPUT.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.SELECT_CELL_TO_MOVE_MESSAGE.getMessage());
        String direction = Console.readLine();
        validateMove(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.ENTER_WHETHER_TO_RETRY_GAME_MESSAGE.getMessage());
        String retry = Console.readLine();
        validateWhetherToRetry(retry);
        return retry;
    }

    /**
     * 다리 길이가 1 이상인지 확인한다.
     * @param size 다리의 길이
     */
    private void validateBridgeSize(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH_INPUT.getMessage());
        }
    }

    /**
     * 이동 방향이 U 또는 D가 맞는지 확인한다.
     * @param direction 다음 이동 방향 (U/D)
     */
    private void validateMove(String direction) {
        if(!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION_INPUT.getMessage());
        }
    }

    /**
     * 게임 재개 입력이 R 또는 Q가 맞는지 확인한다.
     * @param retry 게임 재개 여부 (R/Q)
     */
    private void validateWhetherToRetry(String retry) {
        if(!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_INPUT.getMessage());
        }
    }
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.Constants.BridgeSign.*;
import static bridge.constant.Constants.BridgeSign.DOWN;
import static bridge.constant.Constants.Error.*;
import static bridge.view.OutputView.printCheckRetryMessage;
import static bridge.view.OutputView.printEnter;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * <p>
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 * <p>
 * ★ InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 */
public class InputView {

    /**
     * [제공된 메서드]
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String size = Console.readLine();
        validateBridgeSize(size);
        printEnter();
        return Integer.parseInt(size);
    }

    /**
     * [제공된 메서드]
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String movingDirection = Console.readLine();
        validateDirection(movingDirection);
        return movingDirection;
    }

    /**
     * [제공된 메서드]
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static boolean readGameCommand() {
        printCheckRetryMessage();
        String retryCheck = Console.readLine();
        validateRetryCheckValue(retryCheck);

        if (retryCheck.equals(QUIT)) {
            return false;
        }
        return true;
    }

    private static void validateBridgeSize(String size) {
        validateBridgeSizeInputValueFormat(size);

        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize >= 3 && bridgeSize <= 20) {
            return;
        }
        throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
    }

    private static void validateBridgeSizeInputValueFormat(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateDirection(String direction) {
        if (direction.equals(UP) || direction.equals(DOWN)) {
            return;
        }
        throw new IllegalArgumentException(MOVE_DIRECTION_ERROR_MESSAGE);
    }

    private static void validateRetryCheckValue(String retryCheck) {
        if (retryCheck.equals(QUIT) || retryCheck.equals(RETRY)) {
            return;
        }
        throw new IllegalArgumentException(RETRY_ERROR_MESSAGE);
    }
}

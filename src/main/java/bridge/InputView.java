package bridge;

import camp.nextstep.edu.missionutils.Console;
import static bridge.NumberValidator.validateNonNumeric;
import static bridge.NumberValidator.validateRange;
import static bridge.validator.TextValidator.validateMoveWay;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        String bridgeSize;
        while (true) {
            try {
                bridgeSize = Console.readLine();
                validateNonNumeric(bridgeSize);
                validateRange(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        OutputView.printMoveInputMessage();
        String moveWay;
        while (true) {
            try {
                moveWay = Console.readLine();
                validateMoveWay(moveWay);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveWay;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.util.ValidationUtil;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private ValidationUtil validationUtil = new ValidationUtil();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validationUtil.validateBridgeSizeNullInput(bridgeSize);
        validationUtil.validateBridgeSizeDigitInput(bridgeSize);
        validationUtil.validateBridgeSizeInput(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement = Console.readLine();
        validationUtil.validateUserMovementIfNull(movement);
        validationUtil.validateUserMovement(movement);

        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String exitCode = Console.readLine();
        validationUtil.validateExitCode(exitCode);

        return exitCode;
    }
}

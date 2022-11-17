package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidationUtil;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());
        ValidationUtil.validateBridgeSizeInput(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement = Console.readLine();
        ValidationUtil.validateUserMovement(movement);

        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String exitCode = Console.readLine();
        ValidationUtil.validateExitCode(exitCode);

        return exitCode;
    }
}

package bridge;

import bridge.validator.InputValidator;
import bridge.validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();

        InputValidator.isDigit(size);
        InputValidator.isInBoundary(size);

        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String nextStep = Console.readLine();

        PlayerInputValidator.canMove(nextStep);

        return nextStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String finish = Console.readLine();

        try {
            PlayerInputValidator.canFinish(finish);
        } catch (IllegalArgumentException retry) {
            readGameCommand();
        }

        return finish;
    }
}

package bridge.view;

import bridge.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeLength = Console.readLine();
        validator.validateBridgeLength(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movement = Console.readLine().toUpperCase();
        validator.validateMovement(movement);
        return movement;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String restartOrQuit = Console.readLine().toUpperCase();
        validator.validateRestartOrQuit(restartOrQuit);
        return restartOrQuit;
    }
}

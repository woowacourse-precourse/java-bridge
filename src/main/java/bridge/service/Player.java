package bridge.service;

import bridge.io.InputView;
import bridge.io.OutputView;

public class Player {

    private final Validator validator = new Validator();
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public int enterBridgeLength() {
        while (true) {
            try {
                String bridgeLength = input.readBridgeLength();
                validator.validateBridgeLength(bridgeLength);
                return Integer.parseInt(bridgeLength);
            } catch (IllegalArgumentException exception) {
                output.printError(exception);
            }
        }
    }

    public String enterMovement() {
        while (true) {
            try {
                String movement = input.readMovement();
                validator.validateMovement(movement);
                return movement;
            } catch (IllegalArgumentException exception) {
                output.printError(exception);
            }
        }
    }

    public char enterRetryStatus() {
        // 재시도 여부 입력 R or Q
        // 재시도 여부 입력값 검증
        return '0';
    }
}

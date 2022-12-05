package bridge.view.exception;

import bridge.view.Input;
import bridge.view.InputView;
import bridge.view.validation.InputValidation;

public class ProxyInputView implements Input {
    private final Input input;

    public ProxyInputView(InputValidation inputValidation) {
        input = new InputView(inputValidation);
    }

    @Override
    public int readBridgeSize() {
        while (true) {
            try {
                return input.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public String readMoving() {
        while (true) {
            try {
                return input.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public String readGameCommand() {
        while (true) {
            try {
                return input.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}

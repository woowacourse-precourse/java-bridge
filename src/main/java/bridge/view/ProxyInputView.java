package bridge.view;

import bridge.Validation;

public class ProxyInputView implements Input{
    private final Input input;
    public ProxyInputView(Validation validation) {
        input = new InputView(validation);
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

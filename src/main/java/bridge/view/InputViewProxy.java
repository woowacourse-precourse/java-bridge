package bridge.view;

public class InputViewProxy extends InputView {

    @Override
    public int readBridgeSize() {
        try {
            return super.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readBridgeSize();
        }
    }

    @Override
    public String readMoving() {
        try {
            return super.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readMoving();
        }
    }

    @Override
    public String readGameCommand() {
        try {
            return super.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readGameCommand();
        }
    }
}

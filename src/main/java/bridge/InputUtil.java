package bridge;

import bridge.view.InputView;

public class InputUtil {
    InputView inputView = new InputView();

    public int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputView.readBridgeSize();
        }
    }

    public String getMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputView.readMoving();
        }
    }

    public String getGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputView.readGameCommand();
        }
    }

}

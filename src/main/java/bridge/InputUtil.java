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


}

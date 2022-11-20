package bridge;

import static bridge.view.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        try {
            int bridgeSize = readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

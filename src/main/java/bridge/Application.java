package bridge;

import view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            new BridgeGame().move();
        } catch (IllegalArgumentException e) {
            new OutputView().printException(e.getMessage());
        }
    }
}

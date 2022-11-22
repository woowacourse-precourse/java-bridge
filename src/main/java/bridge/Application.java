package bridge;

import bridge.domain.BridgeGameController;
import bridge.view.OutputView;
import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController gameController = new BridgeGameController();
            gameController.start();
        } catch (NullPointerException
                | IllegalArgumentException
                | IndexOutOfBoundsException
                | NoSuchElementException
                | IllegalStateException exception) {
            OutputView.printErrorMessage(exception);
        }
    }
}

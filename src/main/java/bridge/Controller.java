package bridge;

import bridge.service.Service;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    Service service = new Service();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        printGameStartMessage();
        setGame();
//        playGame();
    }

    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }

    private void setGame() {
        try {
            String bridgeSizeInput = inputView.readBridgeSize();
            service.prepareGame(bridgeSizeInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setGame();
        }
    }
}

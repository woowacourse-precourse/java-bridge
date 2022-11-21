package bridge;

import bridge.controller.ConsoleController;
import bridge.controller.DataTransferController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleController consoleController = new ConsoleController(new InputView(), new OutputView());
        DataTransferController dataTransferController = new DataTransferController();

        BridgeGame bridgeGame = new BridgeGame(consoleController, dataTransferController);
        bridgeGame.run();
    }
}
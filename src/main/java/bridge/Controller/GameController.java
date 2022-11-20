package bridge.Controller;

import bridge.Model.Bridge;
import bridge.Service.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {
    private BridgeGame bridgeGame = new BridgeGame();
    private int progress;

    public void run(Bridge bridge) {
        boolean isCrossable = true;
        progress = 0;

        while (isCrossable) {
            String input = handleInput();
            String currentResult = bridge.getResult(input, progress);
            isCrossable = bridgeGame.isCrossable(currentResult);

            progress = bridgeGame.move(progress);
            printResult(currentResult, input);
        }
    }

    public String handleInput() {
        InputView inputView = new InputView();

        String input = inputView.readMoving();

        return input;
    }

    public void printResult(String currentResult, String input) {
        OutputView outputView = new OutputView();

        outputView.printMap(currentResult, input, progress);
    }
}

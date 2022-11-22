package bridge;

import utils.Validation;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Validation());
        OutputView outputView = new OutputView();

        outputView.printStartMessage();
        BridgeGame game = new BridgeGame(inputView, outputView);
        game.start();
    }
}

package bridge;

import utils.Validation;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Validation());
        OutputView outputView = new OutputView();

        BridgeGame game = new BridgeGame(inputView, outputView);

        outputView.printStartMessage();
        game.start();
    }
}

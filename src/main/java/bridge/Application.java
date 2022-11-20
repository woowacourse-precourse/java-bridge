package bridge;

import exception.UserInputException;
import game.Controller;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            OutputView.printStartMessage();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
            Controller.run(bridge);
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}

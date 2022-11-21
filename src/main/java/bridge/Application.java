package bridge;

import exception.UserInputException;
import game.Controller;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        while (true) {
            try {
                List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
                Controller controller = new Controller();
                controller.run(0, bridge);
                break;
            } catch (UserInputException e) {
                e.printStackTrace();
            }
        }
    }
}

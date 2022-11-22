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
                setController(bridgeMaker);
                break;
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void setController(BridgeMaker bridgeMaker) {
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        Controller controller = new Controller();
        controller.run(0, bridge);
    }
}

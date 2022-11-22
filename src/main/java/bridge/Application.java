package bridge;

import game.Controller;
import utils.InputCheck;
import view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartMessage();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        setController(bridgeMaker);
    }

    public static void setController(BridgeMaker bridgeMaker) {
        List<String> bridge = bridgeMaker.makeBridge(InputCheck.bridgeSizeValue());
        Controller controller = new Controller();
        controller.run(0, bridge);
    }
}

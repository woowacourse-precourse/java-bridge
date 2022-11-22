package bridge;
import java.util.List;


public class Controller {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker maker = new BridgeMaker(generator);
    int bridgeSize = 0;

    public void control() {
        inputView.readBridgeSize();
        bridgeSize = inputView.getBridgeSize();
        List<String> upAndDown = maker.makeBridge(bridgeSize);
        inputView.readMoving();
        String moving = inputView.getReadMoving();
        List<String> yesOrNo = bridgeGame.move(moving, upAndDown);
        String bridge = outputView.printMap(yesOrNo, upAndDown, bridgeSize);
        outputView.printResult(yesOrNo, bridge);
    }

    public void startGame() {
        control();
    }
}

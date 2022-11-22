package bridge;

import java.util.List;

import static bridge.ValidateBridge.validateBridgeSize;
import static bridge.ValidateBridge.validateMovement;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    }

    public void run() {
        String beforeValidateSize = inputView.readBridgeSize();
        int size = validateBridgeSize(beforeValidateSize);
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
        int tryCount = 1;
        int index = 0;
        while(index < bridge.size()) {
            String BeforeMovement = inputView.readMoving();
            String movement = validateMovement(BeforeMovement);
            boolean isContinue = bridgeGame.move(movement, index);
            outputView.printMap(bridgeGame);
            if (isContinue == false) {
                inputView.readGameCommand();
                bridgeGame.retry();
                tryCount++;
                continue;
            }
            index++;
        }
    }
}

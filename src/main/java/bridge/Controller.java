package bridge;

import java.util.List;

import static bridge.ValidateBridge.*;

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
        try {
            String beforeValidateSize = inputView.readBridgeSize();
            int size = validateBridgeSize(beforeValidateSize);
            List<String> bridge = bridgeMaker.makeBridge(size);
            bridgeGame = new BridgeGame(bridge);
            int index = 0;
            boolean isSuccess = true;
            while (index < bridge.size()) {
                String beforeMovement = inputView.readMoving();
                String movement = validateMovement(beforeMovement);
                boolean isContinue = bridgeGame.move(movement, index);
                outputView.printMap(bridgeGame);
                if (isContinue == false) {
                    String beforeValidateRetry = inputView.readGameCommand();
                    String retry = validateRetry(beforeValidateRetry);
                    boolean isRetry = bridgeGame.retry(retry);
                    if (isRetry) {
                        index = 0;
                        continue;
                    }
                    isSuccess = false;
                    break;
                }
                index++;
            }
            outputView.printResult(isSuccess, bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

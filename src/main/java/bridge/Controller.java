package bridge;

import java.util.List;

import static bridge.ValidateBridge.*;

public class Controller {
    private int bridgeIndex;
    private boolean isSuccess;

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
        bridgeIndex = 0;
        isSuccess = true;
    }

    public void run() {
        try {
            int size = inputSize();
            makeBridge(size);
            playGame();
            output();
        } catch (IllegalArgumentException e) {
            outputException(e.getMessage());
        }
    }

    private void outputException(String message) {
        outputView.printException(message);
    }

    private void output() {
        outputView.printResult(isSuccess, bridgeGame);
    }

    private void playGame() {
        while (bridgeIndex < bridgeGame.getBridge().size()) {
            boolean isContinue = move(bridgeIndex);
            bridgeIndex++;
            boolean isRetry = checkRetry(isContinue);
            if (!isRetry) {
                break;
            }
        }
    }

    private boolean checkRetry(boolean isContinue) {
        if (isContinue == false) {
            String retry = inputRetry();
            boolean isRetry = bridgeGame.retry(retry);
            if (!isRetry) {
                isSuccess = false;
                return false;
            }
            bridgeIndex = 0;
        }
        return true;
    }

    private String inputRetry() {
        String beforeValidateRetry = inputView.readGameCommand();
        String retry = validateRetry(beforeValidateRetry);
        return retry;
    }

    private boolean move(int bridgeIndex) {
        String beforeMovement = inputView.readMoving();
        String movement = validateMovement(beforeMovement);
        boolean isContinue = bridgeGame.move(movement, bridgeIndex);
        outputView.printMap(bridgeGame);
        return isContinue;
    }

    private void makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        bridgeGame = new BridgeGame(bridge);
    }

    private int inputSize() {
        String beforeValidateSize = inputView.readBridgeSize();
        int size = validateBridgeSize(beforeValidateSize);
        return size;
    }
}

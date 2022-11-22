package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    InputView inputView;
    OutputView outputView;

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> correctBridge;
    BridgeGame bridge;

    public void initGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        correctBridge = new ArrayList<>(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridge = new BridgeGame(correctBridge);
    }

    public void run() {
        initGame();
        boolean flag = true;
        while (flag) {
            flag = progress();
        }
        outputView.printResult(bridge.getUpBridgeUserAnswerTable(), bridge.getDownBridgeUserAnswerTable(), bridge.getTryCount());
    }

    private boolean progress() {
        for (int i = 0; i < correctBridge.size(); i++) {
            boolean isRightMove = bridge.move(inputView.readMoving());
            outputView.printMap(bridge.getUpBridgeUserAnswerTable(), bridge.getDownBridgeUserAnswerTable(), i+1);
            boolean isRetryGame = retryGame(isRightMove);
            if (!isRetryGame) {
                return false;
            }
        }
        return false;
    }

    private boolean retryGame(boolean rightMove) {
        if (!rightMove) {
            if (inputView.readGameCommand().equals("Q") || inputView.readGameCommand().equals("q")) {
                return false;
            }
            bridge.retry();
        }
        return true;
    }
}

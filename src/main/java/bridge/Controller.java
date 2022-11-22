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
            flag = progress(correctBridge.size());
        }
        outputView.printResult(bridge.getUpBridgeUserAnswerTable(), bridge.getDownBridgeUserAnswerTable(), bridge.getTryCount());
    }

    private boolean progress(int size) {
        for (int i = 0; i < size; i++) {
            boolean isRightMove = bridge.move(inputView.readMoving());
            outputView.printMap(bridge.getUpBridgeUserAnswerTable(), bridge.getDownBridgeUserAnswerTable(), i + 1);
            if (!isRightMove) {
                return retryGame(inputView.readGameCommand());
            }
        }
        return false;
    }

    private boolean retryGame(String retryGameChoice) {
        if (retryGameChoice.equals("R") || retryGameChoice.equals("r")) {
            bridge.retry();
            return true;
        }
        return false;
    }
}

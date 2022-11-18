package bridge;

import bridge.bridgeMaker.BridgeMaker;
import bridge.bridgeMaker.BridgeNumberGenerator;
import bridge.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.input.InputView;

import java.util.List;

public class GameStart {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private int bridgeSize;
    private List<String> bridge;

    public GameStart() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
    }

    public void run() {
        createBridge();
        for (int i = 0; i < bridgeSize; i++) {
            String moveBlock = inputView.readMoving();
            boolean isMove = bridgeGame.move(moveBlock);
            outputView.printMap();
            if (!isMove) {
                String restart = inputView.readGameCommand();
                bridgeGame.retry();
            }
        }
        outputView.printResult();
    }

    private void createBridge() {
        outputView.printInputSizeMessage();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}

package bridge;

import bridge.domain.bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public static int tryNumber = 0;
    private int size;
    void init(){
        outputView.startPrint();
        size = inputView.readBridgeSize();
        bridgeGame.makeBridge(size);
        run();
    }
    void run(){
        tryNumber++;
        for (int i = 0 ;i<size;i++) {
            outputView.gamePrint();
            bridgeGame.setPlayer(inputView.readMoving());
            if (bridgeGame.move(i)){
                continue;
            }
            if (bridgeGame.retry()){
                run();
                return;
            }
        }
        bridgeGame.endGame();
    }
}

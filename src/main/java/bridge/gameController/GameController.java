package bridge.gameController;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();

    private List<String> builtBridge;

    private int location;
    private int cnt;

    public void run() {
        makeBridge();

        boolean flag = true;
        while (flag) {
            cnt++;
            boolean b = moveBridge();
            if (b == true) {
                return;
            }
            flag = retryCheck();
        }

//        outputView.printResult();
    }
    public void makeBridge() {
        outputView.startMessage();
        builtBridge = bridgeGame.makeBridge(inputView.readBridgeSize());
    }

}


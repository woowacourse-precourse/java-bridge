package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeRestart {
    public void bridgeRestart(String playerCommand, List correctBridge) {
        int quitRetryCommand = 0;
        quitRetryCommand = BridgeGame.retry(playerCommand);
        if (quitRetryCommand == 0) {
            OutputView outputView = new OutputView();
            outputView.printMap(correctBridge);
        }
    }

}

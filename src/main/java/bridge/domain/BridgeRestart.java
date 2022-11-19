package bridge.domain;

import bridge.view.OutputView;
import java.util.List;

public class BridgeRestart {
    int quitRetryCommand = 0;
    public void bridgeRestartCheck(String playerCommand, List correctBridge) {
        quitRetryCommand = BridgeGame.retry(playerCommand);
        if (quitRetryCommand == 0) {
            bridgeReStart(correctBridge);
        } if(quitRetryCommand == 1) {
            bridgeQuit();
        }
    }

    public void bridgeReStart(List correctBridge) {
        OutputView.tryCount += 1;
        OutputView outputView = new OutputView();
        outputView.printMap(correctBridge);
    }

    public void bridgeQuit() {
        OutputView.successFail = "실패";

    }

}

package bridge;

import bridge.view.OutputView;

public class BridgeRestart {
    public int bridgeRestartCheck(String playerCommand) {
        int quitCommand = 0;
        int quitRetryCommand = BridgeGame.retry(playerCommand);
        if (quitRetryCommand == 0) {
            bridgeReStart();
        } if(quitRetryCommand == 1) {
            bridgeQuit();
            quitCommand = 1;
        } return quitCommand;
    }

    public void bridgeReStart() {
        OutputView.tryCount += 1;
    }

    public void bridgeQuit() {
        OutputView.successFail = "실패";
    }

}

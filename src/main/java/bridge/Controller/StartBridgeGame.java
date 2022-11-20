package bridge.Controller;

import bridge.View.OutputView;

public class StartBridgeGame {
    private OutputView outputView = new OutputView();

    public void run(){
        outputView.printStartGameNotice();
        outputView.printInputBridgeSizeNotice();
    }
}

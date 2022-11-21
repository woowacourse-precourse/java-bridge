package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void start() {
        outputView.printIntro();
        outputView.printRequestBridgeSize();
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(size);
        BridgeGame bridgeGame = new BridgeGame();

        do{
            bridgeGame.retry();
            boolean passable = false;

            do {
                outputView.printRequestMove();
                passable = bridgeGame.move(inputView.readMoving(), bridge);
                outputView.printMap(bridgeGame.getMark(), passable);
                // 다 건너면 탈출
                if(bridgeGame.getCurrent() == size  ){
                    break;
                }
            } while (passable);
            // 다 건너면 탈출
            if(bridgeGame.getCurrent() == size && passable ){
                break;
            }
            outputView.printRequestGameCommand();
        }while (inputView.readGameCommand());

    }
}

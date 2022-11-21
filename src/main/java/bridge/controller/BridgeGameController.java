package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.domain.BridgeGame;

public class BridgeGameController {
    private int trial = 0;
    private BridgeGame bridgeGame;

    public void run(){
        init();
    }

    private void init(){
        OutputView.printStart();
        initTrial();
        makeBridge();
    }

    private void initTrial(){
        trial += 1;
    }

    private void makeBridge(){
        try {
            int size = InputView.readBridgeSize();
            bridgeGame = new BridgeGame(size);

        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
    }
}

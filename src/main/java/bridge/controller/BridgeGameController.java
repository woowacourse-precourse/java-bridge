package bridge.controller;

import bridge.OutputView;

public class BridgeGameController {

    private int trial = 0;

    public void run(){
        init();
    }

    private void init(){
        OutputView.printStart();
        initTrial();
    }

    private void initTrial(){
        trial += 1;
    }
}

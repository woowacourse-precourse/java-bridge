package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;

public class BridgeGameController {
    BridgeGame bridgeGame;

    public void startBridgeGame(){
        OutputView.printGameStart();
        init();

    }

    public void init(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame=new BridgeGame(bridgeMaker.makeBridge(InputView.getBridgeSize()));
    }
}

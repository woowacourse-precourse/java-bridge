package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import utils.BridgeNumberGenerator;
import utils.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameController {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    List<String> bridgeInfo = new ArrayList<>();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    int tryCnt;

    boolean run() {return true;}
}

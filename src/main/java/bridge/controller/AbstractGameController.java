package bridge.controller;

import bridge.service.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameController {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    List<String> bridgeInfo = new ArrayList<>();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
}

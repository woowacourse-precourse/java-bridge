package bridge.util;

import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Constant {
    public static final InputView inputView = new InputView();
    public static final OutputView outputView = new OutputView();
    public static final Exceptions exceptions = new Exceptions();
    public static final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    public static final BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    public static final BridgeGame bridgeGame = new BridgeGame();
}

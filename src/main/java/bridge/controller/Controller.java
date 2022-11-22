package bridge.controller;

import static bridge.constant.Constant.MOVE_UP;
import static bridge.constant.Constant.correctBridge;
import static bridge.constant.Constant.wrongBridge;
import static bridge.constant.Constant.emptyBridge;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final StringBuilder upBuilder = new StringBuilder("[");
    private final StringBuilder downBuilder = new StringBuilder("[");
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


}
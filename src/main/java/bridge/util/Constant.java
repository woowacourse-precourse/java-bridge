package bridge.util;

import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Constant {
    public static final InputView INPUT_VIEW = new InputView();
    public static final OutputView OUTPUT_VIEW = new OutputView();
    public static final Exceptions EXCEPTIONS = new Exceptions();
    public static final BridgeRandomNumberGenerator NUMBER_GENERATOR = new BridgeRandomNumberGenerator();
    public static final BridgeMaker BRIDGE_MAKER = new BridgeMaker(NUMBER_GENERATOR);
    public static final BridgeGame BRIDGE_GAME = new BridgeGame();
}

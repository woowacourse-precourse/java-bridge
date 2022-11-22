package bridge;

import bridge.engine.BridgeGame;
import bridge.engine.BridgeGameEngine;
import bridge.view.BridgeGameView;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintFormatter;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        BridgeGameEngine engine = new BridgeGameEngine(new BridgeGame(), bridgeMaker);
        BridgeGameView view = new BridgeGameView(new InputView(), new OutputView(), new PrintFormatter());

        new BridgeGameController(engine, view).run();
    }
}

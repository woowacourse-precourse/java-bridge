package bridge.step;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class StepFactory {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame bridgeGame = new BridgeGame(bridgeMaker);


    private StepFactory() {

    }

    public static Step makeStep(StepFactoryType type) {
        if (type == StepFactoryType.INIT) {
            return new WelcomeStep(outputView);
        }

        return new PlayGameStep(inputView, outputView, bridgeGame);
    }
}

package bridge.scenario;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class BasicBridgeScenario implements BridgeScenario{
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());


    @Override
    public void play() {

    }
}

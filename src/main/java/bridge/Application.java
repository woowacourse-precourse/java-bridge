package bridge;

import bridge.scenario.BasicBridgeScenario;
import bridge.scenario.BridgeScenario;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeScenario scenario = new BasicBridgeScenario();
        scenario.play();
    }

}

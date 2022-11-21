package bridge;

import bridge.scenario.BasicBridgeScenario;
import bridge.scenario.BridgeScenario;

public class Application {

    public static void main(String[] args) {
        BridgeScenario scenario = new BasicBridgeScenario();
        scenario.play();
    }

}

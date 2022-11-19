package bridge.application;

import bridge.application.config.BridgeGameConfig;
import bridge.application.context.BridgeGameContext;
import bridge.application.step.StartGame;
import bridge.application.step.Step;

public class BridgeGameApplication {

    private Step step;

    public BridgeGameApplication(BridgeGameConfig config) {
        BridgeGameContext context = new BridgeGameContext(config);
        this.step = new StartGame(context);
    }

    public void start() {
        while (step.executable()) {
            step = step.execute();
        }
    }
}

package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeSequenceNumberGenerator bridgeSequenceNumberGenerator = new BridgeSequenceNumberGenerator(
                List.of(1, 0, 1)
        );
        ClassContext.getInstance().setBridgeNumberGenerator(bridgeSequenceNumberGenerator);
        GameLauncher gameLauncher = ClassContext.getInstance().getGameLauncher();

        gameLauncher.launch();
    }
}

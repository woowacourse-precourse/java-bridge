package bridge;

import bridge.game.BridgeGameLauncher;
import bridge.game.context.BridgeGameContextImpl;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new BridgeGameLauncher(
                new BridgeGameContextImpl(),
                new InputView(),
                new OutputView()
        ).execute();
    }
}

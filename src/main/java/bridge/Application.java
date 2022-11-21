package bridge;


import bridge.launcher.BridgeGameLauncher;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGameLauncher launcher = new BridgeGameLauncher(new InputView(), new OutputView(),
                new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator())));

        launcher.init();
        launcher.run();
    }
}

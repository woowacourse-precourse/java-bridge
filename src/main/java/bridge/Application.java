package bridge;


import bridge.launcher.BridgeGameLauncher;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        
        BridgeGameLauncher launcher = new BridgeGameLauncher(inputView, outputView, bridgeGame);

        launcher.init();
        launcher.run();
    }
}

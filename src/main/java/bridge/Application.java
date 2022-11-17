package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static boolean outcome;
    public static int attempt = 1;


    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeMaker randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        output.printStart();
        BridgeGame bridgeGame = new BridgeGame(randomBridge.makeBridge(input.readBridgeSize()));

        playingBridge(input, output, bridgeGame);
    }

    private static void playingBridge (InputView input, OutputView output, BridgeGame bridgeGame)  {

        while (bridgeGame.move(input.readMoving())) {

            if (!bridgeGame.passHistory.contains("UX") && !bridgeGame.passHistory.contains("DX")) {
                output.printMap(bridgeGame.passHistory);
            }
        }
        output.printResult(attempt, outcome, bridgeGame.passHistory);
    }

    public boolean selectRetry (List<String> passHistory) {
        OutputView output = new OutputView();
        InputView input = new InputView();

        output.printMap(passHistory);

        return input.readGameCommand().equals("R");
    }
}

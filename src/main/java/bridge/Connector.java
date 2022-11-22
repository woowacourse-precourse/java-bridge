package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Connector {

    private static boolean gameClear;
    private static int attempt = 1;


    public void playBridge() {
        InputView input = new InputView();
        OutputView output = new OutputView();
        BridgeMaker randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        output.printStart();
        BridgeGame bridgeGame = new BridgeGame(randomBridge.makeBridge(input.readBridgeSize()));

        proceedBridge(input, output, bridgeGame);
    }

    private void proceedBridge (InputView input, OutputView output, BridgeGame bridgeGame)  {

        while (bridgeGame.move(input.readMoving())) {

            if (!bridgeGame.getPassHistory().contains("UX") && !bridgeGame.getPassHistory().contains("DX")) {
                output.printMap(bridgeGame.getPassHistory());
            }
        }
        output.printResult(attempt, gameClear, bridgeGame.getPassHistory());
    }

    public boolean selectRetry (List<String> passHistory) {
        OutputView output = new OutputView();
        InputView input = new InputView();

        output.printMap(passHistory);

        return input.readGameCommand().equals("R");
    }

    public void setGameClear (boolean gameClear) { this.gameClear = gameClear; }

    public void setAttempt (int attempt) {
        this.attempt += attempt;
    }
}

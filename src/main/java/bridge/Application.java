package bridge;

import bridge.controller.GameMachine;
import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Bridge bridge = new Bridge();
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        GameStatistics gameStatistics = new GameStatistics();
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(numberGenerator), new Player(), gameStatistics, bridge);
        InputView inputView = new InputView(bridgeGame, new BridgeException(), gameStatistics);
        OutputView outputView = new OutputView(bridgeGame, gameStatistics, bridge);
        new GameMachine(inputView, outputView);
    }
}

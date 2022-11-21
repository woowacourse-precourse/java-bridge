package bridge;

import bridge.controller.GameMachine;
import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStatistics gameStatistics = new GameStatistics();
        Bridge bridge = new Bridge(gameStatistics);
        BridgeGame bridgeGame = new BridgeGame(new Player(), gameStatistics, bridge);
        OutputView outputView = new OutputView(gameStatistics, bridge);
        InputView inputView = new InputView(bridgeGame, new BridgeException(), outputView);
        new GameMachine(inputView, outputView);
    }
}

package bridge;

import bridge.controller.GameMachine;
import bridge.model.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Bridge bridge = new Bridge(new GameStatistics());
        BridgeGame bridgeGame = new BridgeGame(new Player(), bridge);
        InputView inputView = new InputView(bridgeGame, new BridgeException(), new OutputView(bridge));
        new GameMachine(inputView);
    }
}

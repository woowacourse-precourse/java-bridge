package bridge.controller;

import java.util.List;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.view.OutputView;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        Bridge bridge = createBridge();
        System.out.println(bridge.getBridge());
        Player player = setPlayer();
        crossABridge(bridge, player);
    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSizeInput();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return new Bridge(bridge);
    }

    private Player setPlayer() {
        return new Player();
    }

    private void crossABridge(Bridge bridge, Player player) {
        BridgeGame bridgeGame = new BridgeGame(bridge, player, inputController);
        bridgeGame.move();
        System.out.println("최종 결과다 짜샤");
        System.out.println(player.result);
    }
}
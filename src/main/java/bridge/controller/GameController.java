package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeTile;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame() {
        generateRandomBridge();
        generateMovingTargetTile();
    }

    private Bridge generateRandomBridge() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                List<String> bridgePositions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
                Bridge bridge = Bridge.from(bridgePositions);
                return bridge;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void playOneTurn(Bridge bridge, Player player) {
        BridgeTile movingTargetTile = generateMovingTargetTile();
        bridgeGame.move(bridge, player, movingTargetTile);
    }

    private BridgeTile generateMovingTargetTile() {
        while (true) {
            try {
                String movingPosition = inputView.readMoving();
                BridgeTile movingTile = BridgeTile.findByTilePosition(movingPosition);
                return movingTile;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}

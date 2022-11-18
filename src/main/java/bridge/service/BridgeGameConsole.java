package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeGameConsole {

    private final Emcee emcee = new Emcee();
    private final Player player = new Player();
    private final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final BridgeMaker maker = new BridgeMaker(generator);

    public void run() {
        emcee.guideGame();
        int bridgeLength = createBridgeLength();
        List<String> bridge = maker.makeBridge(bridgeLength);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int attemptCount = playGame(bridgeGame);
        emcee.showGameResult(bridgeGame.createMovementStatus(), bridgeGame.crossedBridge(), attemptCount);
    }

    private int createBridgeLength() {
        emcee.guideEnteringBridgeLength();
        return player.enterBridgeLength();
    }

    private int playGame(BridgeGame bridgeGame) {
        int attemptCount = 0;
        boolean playGame = true;
        while (playGame) {
            attemptCount++;
            playGame = crossTheBridge(bridgeGame);
        }
        return attemptCount;
    }

    private boolean crossTheBridge(BridgeGame bridgeGame) {
        boolean shouldCrossMore = true;
        while (shouldCrossMore) {
            boolean availableMovement = crossBlock(bridgeGame);

            if (!availableMovement) {
                return retryCrossing(bridgeGame);
            }
            shouldCrossMore = !bridgeGame.crossedBridge();
        }
        return false;
    }

    private boolean crossBlock(BridgeGame bridgeGame) {
        emcee.guideEnteringMovement();
        String movement = player.enterMovement();
        boolean availableMovement = bridgeGame.move(movement);
        String movementStatus = bridgeGame.createMovementStatus();
        emcee.showBridgeMovementStatus(movementStatus);
        return availableMovement;
    }

    private boolean retryCrossing(BridgeGame bridgeGame) {
        emcee.guideEnteringRetryStatus();
        String retryStatus = player.enterRetryStatus();
        if (retryStatus.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}

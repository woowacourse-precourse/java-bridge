package bridge;

import bridge.model.Bridge;
import bridge.model.PlayerStatus;
import bridge.view.ConsoleUtil;

import java.util.List;

public class BridgeGameEngine {

    private final BridgeGame bridgeGame;
    private final BridgeFactory bridgeFactory;

    public BridgeGameEngine(final BridgeGame bridgeGame, final BridgeFactory bridgeFactory) {
        this.bridgeGame = bridgeGame;
        this.bridgeFactory = bridgeFactory;
    }

    public List<String> initBridge() {
        int bridgeSize = ConsoleUtil.inputBridgeSize();

        return bridgeFactory.makeBridgeByBridgeMaker(bridgeSize);
    }

    public void playGame() {
        List<String> bridge = initBridge();
        int gameCount = 0;
        while (true) {
            gameCount++;
            Bridge userBridge = bridgeFactory.makeUserBridge();
            PlayerStatus playerStatus = playerMoveBridge(bridge, userBridge);
            if (isGameFinish(gameCount, userBridge, playerStatus)) {
                break;
            }
        }
    }

    public PlayerStatus playerMoveBridge(final List<String> bridge, final Bridge userBridge) {
        PlayerStatus playerStatus = null;

        for (String currentStep : bridge) {
            playerStatus = playerMove(userBridge, playerStatus, currentStep);
            if (!playerStatus.isMatchingFlag()) {
                break;
            }
        }
        return playerStatus;
    }

    private PlayerStatus isMatchingWithBridge(final String currentStep) {
        String nextStep = ConsoleUtil.inputPlayerMoving();

        if (currentStep.equals(nextStep)) {
            return new PlayerStatus(nextStep, true);
        }

        return new PlayerStatus(nextStep, false);
    }

    private PlayerStatus playerMove(final Bridge userBridge,
                            PlayerStatus playerStatus,
                            final String currentStep) {
        playerStatus = isMatchingWithBridge(currentStep);
        bridgeGame.move(userBridge, playerStatus);
        ConsoleUtil.outputBridge(userBridge);

        return playerStatus;
    }

    public boolean isGameFinish(final int gameCount,
                                final Bridge userBridge,
                                final PlayerStatus playerStatus) {
        if (finishGamePlayerWin(gameCount, userBridge, playerStatus)) {
            return true;
        }

        finishGamePlayerLose(gameCount, userBridge, playerStatus);

        return false;
    }

    private boolean finishGamePlayerWin(final int gameCount,
                                        final Bridge userBridge,
                                        final PlayerStatus playerStatus) {
        if (playerStatus.isMatchingFlag()) {
            ConsoleUtil.outputGameResult(userBridge, gameCount, playerStatus);
            return true;
        }
        return false;
    }

    private void finishGamePlayerLose(final int gameCount,
                                      final Bridge userBridge,
                                      final PlayerStatus playerStatus) {
        String retryCommand = ConsoleUtil.inputGameCommand();

        if (bridgeGame.retry(retryCommand)) {
            ConsoleUtil.outputGameResult(userBridge, gameCount, playerStatus);
        }
    }
}

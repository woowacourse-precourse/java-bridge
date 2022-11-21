package bridge;

import bridge.view.ConsoleUtil;

import java.util.List;

public class BridgeGameEngine {

    private final BridgeGame bridgeGame;
    private final BridgeFactory bridgeFactory;

    public BridgeGameEngine(BridgeGame bridgeGame, BridgeFactory bridgeFactory) {
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

    public PlayerStatus playerMoveBridge(List<String> bridge, Bridge userBridge) {
        PlayerStatus playerStatus = null;

        for (String currentStep : bridge) {
            playerStatus = isMatchingWithBridge(currentStep);
            playerMove(userBridge, playerStatus);
            if (!playerStatus.isMatchingFlag()) {
                break;
            }
        }
        return playerStatus;
    }

    private PlayerStatus isMatchingWithBridge(String currentStep) {
        String nextStep = ConsoleUtil.inputPlayerMoving();

        if (currentStep.equals(nextStep)) {
            return new PlayerStatus(nextStep, true);
        }

        return new PlayerStatus(nextStep, false);
    }

    private void playerMove(Bridge userBridge, PlayerStatus playerStatus) {
        bridgeGame.move(userBridge, playerStatus);
        ConsoleUtil.outputBridge(userBridge);
    }

    public boolean isGameFinish(int gameCount, Bridge userBridge, PlayerStatus playerStatus) {
        if (finishGamePlayerWin(gameCount, userBridge, playerStatus)) {
            return true;
        }

        finishGamePlayerLose(gameCount, userBridge, playerStatus);

        return false;
    }

    private boolean finishGamePlayerWin(int gameCount, Bridge userBridge, PlayerStatus playerStatus) {
        if (playerStatus.isMatchingFlag()) {
            ConsoleUtil.outputGameResult(userBridge, gameCount, playerStatus);
            return true;
        }
        return false;
    }

    private void finishGamePlayerLose(int gameCount, Bridge userBridge, PlayerStatus playerStatus) {
        String retryCommand = ConsoleUtil.inputGameCommand();

        if (bridgeGame.retry(retryCommand)) {
            ConsoleUtil.outputGameResult(userBridge, gameCount, playerStatus);
        }
    }
}

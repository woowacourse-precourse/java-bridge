package bridge;

import java.util.List;

public class BridgeGameEngine {

    static InputView inputView;
    static OutputView outputView;

    private final BridgeGame bridgeGame;

    public BridgeGameEngine(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public PlayerStatus playerMoveBridge(List<String> bridge, Bridge userBridge) {
        PlayerStatus playerStatus = null;

        for (String currentStep : bridge) {
            playerStatus = isMatchingWithBridge(currentStep);

            playerMove(userBridge, playerStatus, bridgeGame);

            if (!playerStatus.isMatchingFlag()) {
                break;
            }
        }

        return playerStatus;
    }

    private PlayerStatus isMatchingWithBridge(String currentStep) {
        String nextStep = inputView.readMoving();

        if (currentStep.equals(nextStep)) {
            return new PlayerStatus(nextStep, true);
        }

        return new PlayerStatus(nextStep, false);
    }

    private void playerMove(Bridge userBridge, PlayerStatus playerStatus, BridgeGame bridgeGame) {
        bridgeGame.move(userBridge, playerStatus);
        outputView.printMap(userBridge);
    }
}

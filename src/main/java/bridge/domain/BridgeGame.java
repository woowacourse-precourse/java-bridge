package bridge.domain;

public class BridgeGame {

    private final BridgeGameRound bridgeRound = new BridgeGameRound();
    private final BridgePlayer bridgePlayer;
    private final BridgeAnswer bridgeAnswer;

    public BridgeGame(BridgePlayer bridgePlayer, BridgeAnswer bridgeAnswer) {
        this.bridgePlayer = bridgePlayer;
        this.bridgeAnswer = bridgeAnswer;
    }

    public void startGameWithBridgeSizeAs(int bridgeSize) {
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);
    }

    public BridgeGameState move(BridgeMoveType bridgeType) {
        bridgePlayer.moveTo(bridgeType);
        return bridgeAnswer.compareWith(bridgePlayer);
    }


    public void retry() {
        bridgeRound.nextRound();
        bridgePlayer.clearPlayerBridge();
    }

    public BridgeGameHistory getGameHistory() {
        return BridgeGameHistory.of(bridgePlayer, bridgeAnswer, bridgeRound);
    }
}

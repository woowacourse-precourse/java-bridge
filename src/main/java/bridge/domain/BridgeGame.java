package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameRound bridgeRound;
    private final BridgePlayer bridgePlayer;
    private final BridgeAnswer bridgeAnswer;

    public BridgeGame(BridgeGameRound bridgeRound, BridgePlayer bridgePlayer, BridgeAnswer bridgeAnswer) {
        this.bridgeRound = bridgeRound;
        this.bridgePlayer = bridgePlayer;
        this.bridgeAnswer = bridgeAnswer;
    }

    public void startGameWithBridgeSizeAs(int bridgeSize) {
        bridgeAnswer.setUpAnswerSizeBy(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeMoveType bridgeType) {
        bridgePlayer.moveTo(bridgeType);
    }

    public BridgeGameState checkBridgeAnswer() {
        return bridgeAnswer.compareWith(bridgePlayer);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeRound.nextRound();
        bridgePlayer.clearPlayerBridge();
    }

    public BridgeHistory getHistory() {
        return new BridgeHistory(bridgePlayer, bridgeAnswer);
    }
}

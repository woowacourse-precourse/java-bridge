package bridge.domain;

import java.util.List;

import bridge.constant.Direction;

/**
 * 다리 건너기 게임의 상태를 관리하는 클래스
 */
public class BridgeGameStatus {
    private final List<String> bridgeAnswer;
    private final PlayerChoice playerChoice;

    public BridgeGameStatus(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
        this.playerChoice = new PlayerChoice();
    }

    public void move(Direction direction) {
        playerChoice.add(direction);
    }

    public void retry() {
        playerChoice.clear();
    }

    public static boolean isArrived(BridgeGameStatus bridgeGameStatus) {
        List<String> bridgeAnswer = bridgeGameStatus.bridgeAnswer;
        PlayerChoice playerChoice = bridgeGameStatus.playerChoice;

        return playerChoice.isArrived(bridgeAnswer);
    }

    public static boolean isValid(BridgeGameStatus bridgeGameStatus) {
        List<String> bridgeAnswer = bridgeGameStatus.bridgeAnswer;
        PlayerChoice playerChoice = bridgeGameStatus.playerChoice;

        return playerChoice.isValid(bridgeAnswer);
    }
}
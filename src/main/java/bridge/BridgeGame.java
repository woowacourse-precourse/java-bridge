package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GameStatus gameStatus;
    private List<String> bridgeMoved;
    private List<String> correctBridge;

    public BridgeGame(GameStatus gameStatus, List<String> bridgeMoved, int bridgeSize) {
        this.gameStatus = gameStatus;
        this.bridgeMoved = new ArrayList<>(bridgeMoved);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.correctBridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String moveTo) {
        bridgeMoved.add(moveTo);

        return bridgeMoved;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryStatus) {
        if (retryStatus.equals("R")) {
            bridgeMoved.clear();
            gameStatus.setGameEnd(false);
            gameStatus.setTryCount(gameStatus.getTryCount() + 1);
            return true;
        }
        return false;
    }

    public String isMovable(int currentPosition) {
        if (bridgeMoved.get(currentPosition).equals(correctBridge.get(currentPosition))) {
            if (currentPosition == correctBridge.size() - 1) {
                gameStatus.setGameWon(true);
                gameStatus.setGameEnd(true);
            }
            return "O";
        }
        gameStatus.setGameEnd(true);
        return "X";
    }

    public boolean isGameEnd() {
        return gameStatus.isGameEnd();
    }

    public List<List<String>> decideBridgeValues() {
        int bridgeMovedSize = bridgeMoved.size();
        List<String> bridgeUpperValues = new ArrayList<>();
        List<String> bridgeLowerValues = new ArrayList<>();

        for (int idx = 0; idx < bridgeMovedSize; idx++) {
            bridgeUpperValues.add(decideBridgeValue(idx, "U"));
            bridgeLowerValues.add(decideBridgeValue(idx, "D"));
        }
        return List.of(bridgeUpperValues, bridgeLowerValues);
    }

    private String decideBridgeValue(int idx, String moveTo) {
        if (bridgeMoved.get(idx).equals(moveTo)) {
            return isMovable(idx);
        }
        return " ";
    }

    public List<String> getBridgeMoved() {
        return bridgeMoved;
    }

    public List<String> getCorrectBridge() {
        return correctBridge;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}

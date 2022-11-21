package bridge.model;

import bridge.model.constant.Direction;
import bridge.model.constant.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private final List<String> playerMoves;
    private int numberOfAttempts;

    public BridgeGame() {
        playerMoves = new ArrayList<>();
        numberOfAttempts = 0;
    }

    private void increaseNumberOfAttempts() {
        numberOfAttempts++;
    }

    private void resetPlayerMoves() {
        playerMoves.clear();
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void initializeGame(List<String> bridge) {
        this.bridge = bridge;
        increaseNumberOfAttempts();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        playerMoves.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        resetPlayerMoves();
        increaseNumberOfAttempts();
    }

    public List<String> getUpperMap() {
        return getCurrentMap(bridge, Direction.UP);
    }

    public List<String> getLowerMap() {
        return getCurrentMap(bridge, Direction.DOWN);
    }

    public List<String> getCurrentMap(List<String> bridge, Direction direction) {
        List<String> currentMap = new ArrayList<>();
        for (int index = 0; index < playerMoves.size(); index++) {
            String playerPosition = playerMoves.get(index);
            String bridgePosition = bridge.get(index);
            currentMap.add(comparePosition(playerPosition, bridgePosition, direction));
        }
        return currentMap;
    }

    public String comparePosition(String playerPosition, String bridgePosition, Direction direction) {
        if (playerPosition.equals(direction.getValue())) {
            if (playerPosition.equals(bridgePosition)) {
                return Result.CAN_CROSS.getValue();
            }
            return Result.CANNOT_CROSS.getValue();
        }
        return Result.UNKNOWN.getValue();
    }

    public boolean canTakeNextMove() {
        return hasMadeCorrectMove(playerMoves, bridge) && playerMoves.size() < bridge.size();
    }

    public boolean hasReachedEnd() {
        return hasMadeCorrectMove(playerMoves, bridge) && playerMoves.size() == bridge.size();
    }

    public boolean hasMadeCorrectMove(List<String> moves, List<String> bridge) {
        int lastMoveIndex = moves.size() - 1;
        String lastMove = moves.get(lastMoveIndex);
        String bridgeDirection = bridge.get(lastMoveIndex);
        return lastMove.equals(bridgeDirection);
    }
}

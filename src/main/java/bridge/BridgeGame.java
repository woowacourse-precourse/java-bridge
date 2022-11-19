package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player;
    private final Bridge bridge;

    BridgeGame(Bridge bridge, Player player) {
        this.player = player;
        this.bridge = bridge;
    }

    public boolean playGame(String userInputToMove) {
        move();
        return bridge.generateShapeAndReturnWhetherUserGetTheRightAnswer(userInputToMove, player.getCurrentLocation());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInputToGameRestartOrEnd) {
        validateUserInputIsOnlyROrQ(userInputToGameRestartOrEnd);
        if (userInputToGameRestartOrEnd.equals("R")) {
            player.retry();
            bridge.retry();
            return true;
        }
        return false;
    }

    public boolean isUserReachedToEndOfTheBridge(int bridgeSize) {
        if (player.getCurrentLocation()+1 == bridgeSize) {
            return true;
        }
        return false;
    }

    public int getCountOfTry() {
        return player.getCountOfTry();
    }

    public int getCurrentLocation() {
        return player.getCurrentLocation();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        player.move();
    }

    private void validateUserInputIsOnlyROrQ(String userInputToGameRestartOrEnd) {
        if (userInputToGameRestartOrEnd != "R" && userInputToGameRestartOrEnd != "Q") {
            throw new IllegalArgumentException("[ERROR] R과 Q만 입력할 수 있습니다.");
        }
    }
}

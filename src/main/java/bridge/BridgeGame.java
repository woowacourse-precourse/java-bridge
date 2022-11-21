package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player;
    private final Bridge bridge;

    private final String RESTART = "R";
    private final String GAME_END = "Q";
    private final String GAME_RESTART_OR_QUIT_VALIDATION_MESSAGE = String.format("[ERROR] %s과 %s만 입력할 수 있습니다.", RESTART, GAME_END);

    public BridgeGame(Bridge bridge, Player player) {
        this.player = player;
        this.bridge = bridge;
    }

    public boolean playGame(String userInputToMove) {
        boolean isCorrect = bridge.judgeAnswer(userInputToMove, player.getCurrentLocation());
        if (isCorrect) {
            move();
        }
        return isCorrect;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInputToGameRestartOrEnd) {
        validateUserInputIsOnlyROrQ(userInputToGameRestartOrEnd);
        if (userInputToGameRestartOrEnd.equals(RESTART)) {
            player.retry();
            bridge.retry();
            return true;
        }
        return false;
    }

    private void validateUserInputIsOnlyROrQ(String userInputToGameRestartOrEnd) throws IllegalArgumentException{
        if (!userInputToGameRestartOrEnd.equals(RESTART) && !userInputToGameRestartOrEnd.equals(GAME_END)) {
            throw new IllegalArgumentException(GAME_RESTART_OR_QUIT_VALIDATION_MESSAGE);
        }
    }

    public boolean isUserReachedToEndOfTheBridge(int bridgeSize) {
        return player.getCurrentLocation() == bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        player.move();
    }

    public int getCountOfTry() {
        return player.getCountOfTry();
    }

    public int getCurrentLocation() {
        return player.getCurrentLocation();
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Player getPlayer() {
        return player;
    }
}

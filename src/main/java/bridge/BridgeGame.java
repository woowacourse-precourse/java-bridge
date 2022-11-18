package bridge;

import bridge.constants.ErrorMessages;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final User user;

    public BridgeGame(Bridge bridge) {
        this.user = new User();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param command
     */
    public GameStatus move(String command) {
        validateMoveCommand(command);
        int userStatus = user.cross(bridge, command);
        if (userStatus == User.LIVE) {
            if (isSuccess()) {
                return GameStatus.WIN;
            }
            return GameStatus.KEEP_GOING;
        }
        return GameStatus.LOSE;
    }

    private boolean isSuccess() {
        return user.isLocateAt(bridge.size());
    }

    private void validateMoveCommand(String moveCommand) {
        if (!isMoveCommand(moveCommand)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MOVE_COMMAND);
        }
    }

    private boolean isMoveCommand(String moveCommand) {
        return moveCommand.equals("U") || moveCommand.equals("D");
    }

    public void recordStep(int status, String direction) {
        user.recordStep(status, direction);
    }

    public String getFootPrintsLog() {
        return user.getFootPrintsLog();
    }

    private void validateGameCommand(String gameCommand) {
        if (!isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_GAME_COMMAND);
        }
    }

    private boolean isGameCommand(String gameCommand) {
        return gameCommand.equals("R") || gameCommand.equals("Q");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals("R")) {
            user.prepareToRestart();
            return GameStatus.KEEP_GOING;
        }
        return GameStatus.LOSE;
    }

    public int getTryCount() {
        return user.getTryCount();
    }
}

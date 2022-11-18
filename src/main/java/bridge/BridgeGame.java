package bridge;

import bridge.constants.ErrorMessages;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int END = 0;
    public static final int DIED = 1;
    public static final int KEEP_GOING = 2;

    private final Bridge bridge;
    private int currentLocation;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.currentLocation = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param moveCommand
     */
    public int move(String moveCommand) {
        validateMoveCommand(moveCommand);
        if (bridge.canCross(currentLocation, moveCommand)) {
            currentLocation++;
            if (isEnd(bridge.size())) {
                return END;
            }
            return KEEP_GOING;
        }
        return DIED;
    }

    private boolean isEnd(int brideSize) {
        return brideSize == currentLocation;
    }

    private void validateMoveCommand(String moveCommand) {
        if (!isMoveCommand(moveCommand)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MOVE_COMMAND);
        }
    }

    private boolean isMoveCommand(String moveCommand) {
        return moveCommand.equals("U") || moveCommand.equals("D");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param gameCommand
     */
    public void retry(String gameCommand) {
        validateGameCommand(gameCommand);
    }

    private void validateGameCommand(String gameCommand) {
        if (!isGameCommand(gameCommand)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_GAME_COMMAND);
        }
    }

    private boolean isGameCommand(String gameCommand) {
        return gameCommand.equals("R") || gameCommand.equals("Q");
    }
}

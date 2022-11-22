package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String QUIT = "Q";
    private static final String RETRY = "R";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String INVALID_MOVE_COMMAND_ERROR = "U 또는 D를 입력해주세요.";
    private static final String INVALID_GAME_COMMAND_ERROR = "R 또는 Q를 입력해주세요.";

    private final List<String> bridge;
    private final Player player;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        player = new Player();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveCommand) {
        validateMoveCommand(moveCommand);
        if (isMovable(moveCommand)) {
            player.moveOneSpace();
            return true;
        }
        player.stopPlayer();
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        if (retryCommand.equals(RETRY)) {
            player.resetCurrentPosition();
            player.addOneRetryCount();
            return true;
        }
        if (retryCommand.equals(QUIT)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR);
    }

    private void validateMoveCommand(String moveCommand) {
        if (moveCommand.equals(UP) || moveCommand.equals(DOWN)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_MOVE_COMMAND_ERROR);
    }

    public boolean isReached() {
        int arrivalPosition = bridge.size();
        return arrivalPosition == player.getCurrentPosition();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Player getPlayer() {
        return player;
    }

    private boolean isMovable(String moveCommand) {
        return moveCommand.equals(bridge.get(player.getCurrentPosition()));
    }
}

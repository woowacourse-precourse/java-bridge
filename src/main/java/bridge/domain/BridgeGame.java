package bridge.domain;

import bridge.domain.enums.Direction;
import bridge.domain.enums.GameCommand;
import bridge.domain.enums.GameStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final User user;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.user = new User();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param direction 이동할 방향
     */
    public GameStatus move(Direction direction) {
        int userStatus = user.cross(bridge, direction);
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

    public String getFootPrintsLog() {
        return user.getFootPrintsLog();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param gameCommand 재시작 / 종료 명령
     */
    public GameStatus retry(GameCommand gameCommand) {
        if (gameCommand == GameCommand.RETRY) {
            user.prepareToRestart();
            return GameStatus.KEEP_GOING;
        }
        return GameStatus.LOSE;
    }

    public int getTryCount() {
        return user.getTryCount();
    }
}

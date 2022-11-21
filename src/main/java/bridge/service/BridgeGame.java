package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.support.BridgeLogger;
import bridge.utils.status.GameStatus;

import java.util.List;

import static bridge.utils.status.GameStatus.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeLogger logger;
    private GameStatus status = PLAYING;
    private int tryCount = 1;

    private final User user;
    private final Bridge bridge;

    public BridgeGame(List<String> floors) {
        user = new User();
        bridge = new Bridge(floors);
        logger = new BridgeLogger();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        user.move(bridge, input);
        logger.log(input, user.isLive());
        if (!user.isLive()) {
            this.status = LOSE;
        }
        if (isWin()) {
            this.status = WIN;
        }
    }

    private boolean isWin() {
        return user.getStep() == bridge.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.init();
        logger.clear();
        this.status = PLAYING;
        this.tryCount++;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getResultMap() {
        return logger.toString();
    }
}

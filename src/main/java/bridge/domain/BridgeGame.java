package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.user.MoveType;
import bridge.domain.user.User;
import bridge.domain.user.UserStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final User user;

    public BridgeGame(int size) {
        bridge = initBridge(size);
        user = new User();
    }

    public Bridge initBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return Bridge.initBridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public UserStatus move(String moveType) {
        UserStatus userStatus = user.cross(bridge, MoveType.convertMoveType(moveType));
        return userStatus;
    }

    public String getUserPathLog() {
        return user.getUserPathLog();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
    }
}

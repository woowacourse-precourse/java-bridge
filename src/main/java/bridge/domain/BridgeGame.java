package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final User user;
    private final List<String> matchingStatus;
    private int totalAttempts;
    private boolean gameFailed;

    public BridgeGame(int size) {
        bridge = makeBridge(size);
        user = new User();
        matchingStatus = new ArrayList<>();
        totalAttempts = 1;
        gameFailed = false;
    }

    private Bridge makeBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        user.move(moving);
        if (!bridge.canMove(user.getUserMoved(), user.getLatestLocation())) {
            matchingStatus.add("X");
            gameFailed = true;
            return;
        }
        matchingStatus.add("O");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            user.clearUserMoved();
            matchingStatus.clear();
            gameFailed = false;
            totalAttempts++;
        }
    }

    public boolean isGameEnd() {
        return gameFailed || bridge.isSizeEqualTo(matchingStatus);
    }

    public List<String> getMatchingStatus() {
        return Collections.unmodifiableList(matchingStatus);
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public boolean isGameFailed() {
        return gameFailed;
    }

    public List<String> getUserMoved() {
        return user.getUserMoved();
    }
}

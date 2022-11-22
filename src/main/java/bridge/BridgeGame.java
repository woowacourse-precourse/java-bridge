package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryCount = 1;
    private List<String> answer;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private User user;

    public BridgeGame(int bridgeLength) {
        this.answer = new BridgeMaker(bridgeNumberGenerator).makeBridge(bridgeLength);
        this.user = new User(answer, bridgeLength);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        user.userStateUpdate();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (user.reTryGame()) {
            setGame();
            return true;
        }
        return false;
    }

    public boolean isExit() {
        if (isFail() || isClear())
            return true;
        return false;
    }

    public boolean isFail() {
        if (user.isFailure())
            if (!retry())
                return true;
        return false;
    }

    public boolean isClear() {
        if (user.isSuccess(tryCount))
            return true;
        return false;
    }

    public void setGame() {
        tryCount++;
        this.user = new User(getAnswer(), getAnswer().size());
    }

    public List<String> getAnswer() {
        return answer;
    }
}

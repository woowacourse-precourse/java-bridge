package bridge;

// InputView와 OutputView 사용 불가
// BridgeGame 클래스에 필드(인스턴스 변수) 추가 가능
// 패키지 변경 가능
// 메서드의 이름 변경 불가
// 메서드의 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
// 게임 진행을 위해 필요한 메서드를 추가하거나 변경 가능

import bridge.constant.SuccessFail;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.SuccessFail.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final List<String> bridge;
    public List<String> player = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        player.add(moving);
    }

    public SuccessFail isSuccess(List<String> bridge, List<String> player) {
        if (bridge.equals(player))
            return SUCCESS;
        return FAIL;
    }
    public boolean isFinish() {
        if (isAlive() && (player.size() < bridge.size()))
            return false;

        if (!isAlive() || player.size() == bridge.size())
            return true;

        return false;
    }

    private boolean isAlive() {
        int nowIdx = player.size() - 1;
        String nowBridge = bridge.get(nowIdx);
        String nowPlayer = player.get(nowIdx);
        if (nowPlayer.equals(nowBridge)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player = new ArrayList<>();
    }
}

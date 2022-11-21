package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryCount = 1;
    private List<String> answer;
    private List<String> user;
    private int bridgeLength;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String direction = new InputView().readMoving();
        user.add(direction);
        new OutputView().printMap(answer,user);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void play() {
        this.bridgeLength = new InputView().readBridgeSize();
        this.answer = new BridgeMaker(bridgeNumberGenerator).makeBridge(bridgeLength);
        this.user = new ArrayList<>(bridgeLength);
    }

    public boolean isFail() {
        if (user.size() > 0 && !answer.get(user.size()-1).equals(user.get(user.size()-1))) {
            return true;
        }
        return false;
    }
}

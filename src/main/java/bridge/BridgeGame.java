package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 */
public class BridgeGame {
    private static final int START_POINT = 0;

    private final List<String> bridge;
    private String userPath;
    private int userPosition;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.userPath = null;
        this.userPosition = START_POINT;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        this.userPath = input;
        this.userPosition += 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.userPosition = START_POINT;
    }

    public boolean isCorrectPath() {
        return this.userPath.equals(this.bridge.get(userPosition));
    }

    public String getUserPath() {
        return this.userPath;
    }
}

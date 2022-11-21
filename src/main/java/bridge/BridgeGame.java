package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int INIT_TRY_COUNT = 1;
    public static final int INIT_BRIDGE_INDEX = 0;

    private final List<String> answerBridge;
    private BridgeMap bridgeMap;
    private int bridgeIndex;
    private int tryCount;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        init(INIT_TRY_COUNT);
    }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    public void init(int tryCount) {
        this.bridgeIndex = INIT_BRIDGE_INDEX;
        this.tryCount = tryCount;
        this.bridgeMap = new BridgeMap();
    }
}

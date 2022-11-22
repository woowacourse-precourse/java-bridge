package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge = new ArrayList<>();
    private final List<String> upBridge  = new ArrayList<>(); //
    private final List<String> downBridge = new ArrayList<>();
    private final List<String> moveUser = new ArrayList<>();
    private final List<String> restart = new ArrayList<>();
    private int cnt = 1; // 게임 횟수
    private int bridge_create = 0;

    private final int bridge_len;
    public BridgeGame(int bridge_len) {
        this.bridge_len = bridge_len;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
        public void move(String userInput) {
            if (userInput.equals(Choose.UP.getValue())) {
                moveUser.add(Choose.UP.getValue());
            }
            if (userInput.equals(Choose.DOWN.getValue())) {
                moveUser.add(Choose.DOWN.getValue());
            }
            cnt++;
            makeBridge();
//        return false;
        }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
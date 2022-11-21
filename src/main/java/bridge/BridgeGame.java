package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static  String UP = "U";
    private final static  String DOWN = "D";

    private Bridge bridge;
    private int step;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.step = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean checkMovable(String selectedSpace){
        validate(selectedSpace);
        return bridge.checkMovable(step, selectedSpace);
    }

    public void move() {
        step += 1;
    }

    public void validate(String selectedSpace) {
        if (!selectedSpace.equals(UP) && !selectedSpace.equals(DOWN)) {
            throw new IllegalArgumentException("U 또는 D를 입력해주세요.");
        }
    }

    public boolean checkEnd(){
        if (step == bridge.getBridgeSize()) {
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



    }
}

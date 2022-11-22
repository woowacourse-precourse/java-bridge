package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final String MOVE_POSSIBLE = " O ";
    private final String MOVE_IMPOSSIBLE = " X ";
    private final String NOT_SELECTED = "   ";
    private final String BRIDGE_START = "[";
    private final String BRIDGE_END = "]";
    private final String BRIDGE_MIDDLE = "|";

    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();
    private int acrossBridge = 0;

    private int count = 1;


    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
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
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public int accrosBridgePlus() {
        return this.acrossBridge = acrossBridge + 1;
    }

    public int getAcrossBridge() {
        return acrossBridge;
    }

    public int getCount() {
        return count;
    }

    public int countPlus() {
        return this.count = count + 1;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }
}

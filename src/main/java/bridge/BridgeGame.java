package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeMaker bridgeMaker;

    private Bridge bridge;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {

    }

    private void gameSituation() {
        List<String> brige = initGame();
    }

    public List<String> initGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> newBridge = this.bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(newBridge);
        return newBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (true) {
            int status = bridge.getState();
            moveNext(status);
        }
    }

    private void moveNext(int status) {
        String direction = inputView.readMoving();
        String input = input(direction, bridge.getbridge().get(status));
    }

    private String input(String user, String answer) {
        if ( !user.equals(answer)) {
            return "X";
        }
        return "O";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

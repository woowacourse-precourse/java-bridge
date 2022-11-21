package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final private InputView inputView;
    final private OutputView outputView;
    final private BridgeMaker bridgeMaker;

    private List<String> bridge;

    /**
     * BridgeGame 필드 초기화 생성자
     */
    public BridgeGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new ArrayList<>();
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

    /**
     * 다리를 생성하는 메서드
     */
    public void buildBridge() {
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 전체 게임 동작 관리를 위해 사용하는 메서드
     */
    public void start() {
        int tryCount = 0;
        outputView.printStartGame();
        buildBridge();
        move();
    }
}

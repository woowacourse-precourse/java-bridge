package bridge;

import bridge.repository.BridgeMoveRepository;
import bridge.service.BridgeMoveService;
import bridge.service.RetryService;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final BridgeMoveController bridgeMoveController;
    private int count = 0;

    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = bridgeMaker.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeMoveController = new BridgeMoveController(bridgeSize,
                new BridgeMoveService(new BridgeMoveRepository(), bridge));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        bridgeMoveController.clear();
        List<String>[] bridgeMove = bridgeMoveController.run();
        count++;
        retry(bridgeMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String>[] bridgeMove) {
        RetryController retryController = new RetryController(new RetryService(), bridgeMove, count);
        if (retryController.run()) {
            move();
        }
    }
}

package bridge;

import bridge.controller.BridgeMoveController;
import java.util.List;
import view.InputView;
import view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int count = 0;

    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = bridgeMaker.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String successful = "성공";
        List<String>[] moveBridge = new BridgeMoveController(bridge).run();
        count++;

        if (moveBridge[0].contains("X") || moveBridge[1].contains("X")) {
            successful = "실패";
            Retry retry = new Retry(new InputView().readGameCommand());
            String retryCommand = retry.getRetry();
            if (retryCommand.equals("R")) {
                retry();
                return;
            }
        }
        new OutputView().printResult(moveBridge, successful, count);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        move();
    }
}

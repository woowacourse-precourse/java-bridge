package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Statistics;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeNumberGenerator bridgeNumberGenerator;
    private Bridge bridge;
    private Statistics statistics;
    private boolean moveSuccess;

    public void start(BridgeNumberGenerator bridgeNumberGenerator) {
        try {
            init(bridgeNumberGenerator);
            tryGame();
            OutputView.printResult(bridge.getPlayerMovingHistory(), isGameEndWithSuccess(),
                    statistics.getTryCount());
        } catch (RuntimeException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private void tryGame() {
        while (moveSuccess) {
            move();
            if (isGameEndWithSuccess()) {
                return;
            }
        }
        checkGameCommand();
    }

    private void checkGameCommand() {
        if (readGameCommand().equals("R")) {
            retry();
        }
    }

    private void init(BridgeNumberGenerator bridgeNumberGenerator) {
        OutputView.startBridgeGame();
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        int size = readBridgeSize();
        List<String> bridges = makeBridge(size);
        this.bridge = new Bridge(size, bridges);
        this.statistics = new Statistics();
        this.moveSuccess = true;
    }

    private int readBridgeSize() {
        try {
            OutputView.readBridgeSize();
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        try {
            OutputView.readMoving();
            String moving = InputView.readMoving();
            moveSuccess = bridge.updateMoving(moving);
            OutputView.printMap(bridge.getPlayerMovingHistory(), moveSuccess);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            move();
        }
    }

    private boolean isGameEndWithSuccess() {
        return bridge.reachEndOfBridge() && moveSuccess;
    }

    private String readGameCommand() {
        try {
            OutputView.readGameCommand();
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readGameCommand();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridge.clearPlayerMovingHistory();
        moveSuccess = true;
        statistics.update();
        tryGame();
    }
}

package bridge;

import bridge.Setting.BridgeRetryIndex;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final BridgeResult bridgeResult;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeResult = new BridgeResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move() {
        while (keepMove()) {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            String readMoving = inputView.readMoving();

            bridgeResult.addSideIndies(bridge, readMoving);
            outputView.printMap(bridgeResult.getMap());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if (!isEnd()) {
            InputView inputView = new InputView();
            String gameCommand = inputView.readGameCommand();

            if (gameCommand.equals(BridgeRetryIndex.QUIT.getLabel())) {
                return;
            }
            if (gameCommand.equals(BridgeRetryIndex.RETRY.getLabel())) {
                bridgeResult.retryResult();
            }
        }
    }

    public String getResult() {
        return bridgeResult.getResult(bridge.size());
    }

    public boolean keepMove() {
        return !isEnd() && bridgeResult.lastBridgeCorrect();
    }

    public boolean isEnd() {
        return bridgeResult.getEachSideIndiesSize() == bridge.size();
    }
}

package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.domain.Step;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private GameResult gameResult;

    public BridgeGame(int size) {
        makeBridge(size);
        gameResult = new GameResult();
    }

    private void makeBridge(int size) {
        this.bridge = new Bridge(getStringBridge(size));
    }

    private List<String> getStringBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(Step to) {
        gameResult.addResult(to, bridge.move(to));
        isFinished(gameResult);
        return gameResult;
    }

    private void isFinished(GameResult gameResult) {
        if (bridge.isFinished()) {
            gameResult.setGameSuccess();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameResult.init();
        bridge.retry();
    }
}

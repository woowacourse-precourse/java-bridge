package bridge.model;

import bridge.BridgeMaker;
import bridge.domain.ResultSymbol;
import bridge.domain.Bridge;
import bridge.domain.BridgeResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private Bridge bridges;
    private BridgeResult bridgeResult;
    private int gameTryCount = 1;
    private ResultSymbol resultSymbol;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void create(int bridgeSize) {
        bridges = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeResult = new BridgeResult(bridges);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        resultSymbol = bridgeResult.move(moveCommand);
    }

    public BridgeResult printLines() {
        return bridgeResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeResult.reset();
        gameTryCount++;
    }

    public boolean allTry() {
        return bridges.getCount() == bridgeResult.getCrossingCount();
    }

    public ResultSymbol getResultSymbol() {
        return resultSymbol;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}

package bridge;

import java.util.List;

import bridge.domain.BridgeNumber;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridgeColumns;
    private int gamePlayCount = 0;
    private int moveCount = 0;

    public void make() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = bridgeMaker.inputBridgeSize();
        bridgeColumns = bridgeMaker.makeBridge(size);
        System.out.println(bridgeColumns);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        BridgeMover bridgeMover = new BridgeMover();
        boolean movable;
        do {
            String markToMove = bridgeMover.inputBridgeMarkToMove();
            movable = bridgeColumns.get(moveCount++).equals(markToMove);
            BridgeNumber.addResultToMap(markToMove, movable);
            bridgeMover.printBridgeResultMap();
        } while(!isGameSuccess(movable));
    }

    private boolean isGameSuccess(boolean movable) {
        if(!movable) {
            return false;
        }
        return moveCount == bridgeColumns.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public void retry() {
        // BridgeMover bridgeMover = new BridgeMover();
        // gamePlayCount++;
        // moveCount = 0;
    }
}

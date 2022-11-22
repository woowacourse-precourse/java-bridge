package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> randomBridge;
    private Result result;
    private int moveCount;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        randomBridge = bridgeMaker.makeBridge(size);
        result = new Result();
        moveCount = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (randomBridge.get(moveCount).equals(direction)) {
            result.appendResult(ResultType.SUCCESS, Direction.getDirection(direction));
            moveCount += 1;
            return;
        }
        result.appendResult(ResultType.FAIL, Direction.getDirection(direction));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result = new Result();
        moveCount = 0;
    }

    public Result getGameResult() {
        return result;
    }

    public boolean isGameFailed() {
        return result.getLastResultType() == ResultType.FAIL;
    }

    public boolean isGameFinished() {
        return moveCount == randomBridge.size();
    }

}

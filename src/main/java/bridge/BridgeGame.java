package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<Direction> randomBridge;
    private Result result;
    private int moveCount;

    public BridgeGame(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        randomBridge = Direction.getDirections(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));
        result = new Result(0);
        moveCount = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        if (randomBridge.get(moveCount) == direction) {
            result.appendResult(ResultType.SUCCESS, direction);
            moveCount += 1;
            return;
        }
        result.appendResult(ResultType.FAIL, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result = new Result(result.getCount());
        moveCount = 0;
    }

    /**
     * 게임의 결과를 반환하는 메서드
     * 
     * @return Result 객체
     */
    public Result getGameResult() {
        return result;
    }

    /**
     * 마지막에 실패했는지 확인하는 메서드
     * 
     * @return 실패했으면 true, 아니면 false
     */
    public boolean isFailed() {
        return result.getLastResultType() == ResultType.FAIL;
    }

    /**
     * 게임이 끝났는지 확인하는 메서드
     * 
     * @return 게임이 끝났으면 true, 아니면 false
     */
    public boolean isGameFinished() {
        return moveCount == randomBridge.size();
    }

}

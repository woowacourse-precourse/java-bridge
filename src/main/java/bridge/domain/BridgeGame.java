package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Direction;
import bridge.constant.RetryCommand;
import bridge.dto.CurrentGameResultResponse;
import bridge.dto.FinishedGameResultResponse;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Result result;
    private int playCount;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.result = new Result();
        this.playCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInput) {
        Direction userDirection = Direction.from(userInput);

        result.update(bridge, userDirection);
    }

    public boolean isEnd() {
        return result.isEnd(bridge);
    }

    public boolean isSuccess() {
        return result.isSuccess(bridge);
    }

    public final CurrentGameResultResponse resultOfMoving() {
        return new CurrentGameResultResponse(result.getMoveStatuses());
    }

    public final FinishedGameResultResponse resultOfFinishedGame() {
        return new FinishedGameResultResponse(result.getMoveStatuses(), result.isSuccess(bridge), playCount);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (!RetryCommand.canRetry(userInput)) {
            return false;
        }
        prepareRetry();

        return true;
    }

    private void prepareRetry() {
        result.reset();
        playCount++;
    }
}

package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int stage;
    private int totalTryCount;
    private Bridge bridge;
    private boolean isEnd = false;
    private boolean isSuccess = false;

    public BridgeGame(int size, BridgeNumberGenerator generator) {
        this.stage = 0;
        this.totalTryCount = 0;
        makeBridge(size, generator);
    }

    private void makeBridge(int size, BridgeNumberGenerator generator) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(String userInput) {
        GameResult gameResult = makeGameResult(userInput);
        this.stage++;
        isGameSuccess();
        return gameResult;
    }

    public GameResult makeGameResult(String userInput) {
        boolean canUserMove = canMove(userInput);
        List<BridgeState> subBridge = bridge.makeSubBridge(stage);
        MoveResult moveResult = MoveResult.makeMoveResult(canUserMove);
        checkGameEnd(userInput);
        return new GameResult(moveResult, subBridge);
    }

    private boolean canMove(String userInput) {
        if (bridge.isSameTile(userInput, stage)) {
            return true;
        }
        return false;
    }

    public void checkGameEnd(String userInput) {
        if (!canMove(userInput) || isGameSuccess()) {
            isEnd = true;
            totalTryCount++;
        }
    }

    public boolean isGameSuccess() {
        if (!isEnd && bridge.isLastTile(stage)) {
            isSuccess = true;
            totalTryCount++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.stage = 0;
        this.isEnd = false;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }
}

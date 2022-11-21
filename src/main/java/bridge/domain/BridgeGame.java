package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int stage;
    private int totalTryCount;
    private Bridge bridge;

    public BridgeGame(int size) {
        this.stage = 0;
        this.totalTryCount = 0;
        makeBridge(size);
    }

    private void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResult move(String userInput) {
        this.stage++;
        return makeGameResult(userInput);
    }

    public GameResult makeGameResult(String userInput) {
        boolean canUserMove = canMove(userInput);
        List<BridgeState> subBridge = bridge.makeSubBridge(stage);
        MoveResult moveResult = MoveResult.makeMoveResult(canUserMove);
        return new GameResult(moveResult, subBridge);
    }

    private boolean canMove(String userInput) {
        if (bridge.isSameTile(userInput, stage)) {
            return true;
        }
        return false;
    }

    public boolean isGameEnd(String userInput) {
        if (!canMove(userInput) || isGameSuccess(userInput)) {
            return true;
        }
        return false;
    }

    public boolean isGameSuccess(String userInput) {
        if (canMove(userInput) && bridge.isLastTile(stage)) {
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
        this.totalTryCount++;
        this.stage = 0;
    }
}

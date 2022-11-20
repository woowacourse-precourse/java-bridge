package bridge.model;

import bridge.utils.BridgeMaker;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final GameResult gameResult;
    private Bridges bridge;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        gameResult = GameResult.getInstance();
    }

    public int createBridge(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        bridge = new Bridges(bridgeMaker.makeBridge(size));
        return size;
    }

    public String move(String moveSpace, int index) {
        boolean canMove = bridge.judgeMovement(moveSpace, index);
        return gameResult.updateMoveResult(moveSpace, canMove);
    }

    public boolean fail() {
        return gameResult.canNotGo();
    }

    public void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            gameResult.reset();
        }
        if (gameCommand.equals("Q")) {
            throw new IllegalStateException(getFinishResult());
        }
        throw new IllegalArgumentException("[ERROR] 게임 커멘드 입력 오류입니다");
    }

    public String getFinishResult() {
        return gameResult.toString();
    }
}

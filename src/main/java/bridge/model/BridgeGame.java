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

    public void createBridge(int size) {
        bridge = new Bridges(bridgeMaker.makeBridge(size));
        System.out.println(bridge);
    }

    public String move(String moveSpace, int index) {
        boolean canMove = bridge.judgeMovement(moveSpace, index);
        return gameResult.updateMoveResult(moveSpace, canMove);
    }

    public boolean canNotMove() {
        return gameResult.canNotGo();
    }

    public String retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            gameResult.reset();
            return "continue";
        }
        if (gameCommand.equals("Q")) {
            return getFinishResult();
        }
        throw new IllegalArgumentException("[ERROR] 게임 커멘드 입력 오류입니다");
    }

    public String getFinishResult() {
        return gameResult.toString();
    }
}

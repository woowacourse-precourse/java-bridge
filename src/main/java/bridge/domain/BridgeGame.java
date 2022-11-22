package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answerBridge;
    private final GameResult gameResult;
    private boolean moveState;

    private int tryCount;

    public BridgeGame(Bridge answerBridge) {
        this.answerBridge = answerBridge;
        gameResult = new GameResult();
        moveState = false;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String playerDirection) {
        moveState = checkCrossBridge(playerDirection);
        gameResult.add(playerDirection, moveState);
    }

    /**
     * 사용자가 다리를 건너갈 수 있는지 확인하는 메서드
     */
    public boolean checkCrossBridge(String playerDirection) {
        int moveCount = gameResult.getGameCount();
        String answer = answerBridge.getAnswerDirection(moveCount);
        return answer.equals(playerDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        gameResult.reset();
        moveState = false;
        tryCount += 1;
    }

    /**
     * 사용자가 다리를 끝까지 건넜는지 확인하는 메서드
     */
    public boolean isClearGame() {
        if (answerBridge.getSize() == gameResult.getGameCount()) {
            return false;
        }
        return true;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean getMoveState() {
        return moveState;
    }

    public int getTryCount() {
        return tryCount;
    }
}

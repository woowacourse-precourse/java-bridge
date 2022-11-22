package bridge.domain;

public class BridgeGame {
    private GameResult gameResult;
    private GameReferee referee;

    public BridgeGame(Bridge bridge) {
        gameResult = new GameResult();
        referee = new GameReferee(bridge);
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public boolean move(PlayerMoving playerMoving) {
        boolean isCorrect = referee.isCorrectMoving(playerMoving);
        gameResult.addGameResult(isCorrect, playerMoving);
        return isCorrect; //맞추면 true, 틀리면 false
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
package bridge.model.gameResult;

/**
 * 게임 결과를 저장하는 클래스
 */
public class GameResult {
    protected String map;
    protected boolean succeed;
    protected int numberOfAttempts;

    public GameResult(String map, boolean succeed, int numberOfAttempts) {
        this.map = map;
        this.succeed = succeed;
        this.numberOfAttempts = numberOfAttempts;
    }
}

package bridge.model;

import java.util.List;

/**
 * 게임 결과를 저장하는 클래스
 */
public class GameResult {
    public List<String> map;
    public boolean succeed;
    public int numberOfAttempts;

    public GameResult(List<String> map, boolean succeed, int numberOfAttempts) {
        this.map = map;
        this.succeed = succeed;
        this.numberOfAttempts = numberOfAttempts;
    }
}
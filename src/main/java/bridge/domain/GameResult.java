package bridge.domain;

import java.util.List;

public class GameResult {
    private List<String> upSpace;
    private List<String> downSpace;

    public GameResult(List<String> upSpace, List<String> downSpace){
        this.upSpace = upSpace;
        this.downSpace =downSpace;
    }
}

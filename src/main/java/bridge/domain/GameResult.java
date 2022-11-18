package bridge.domain;

import java.util.List;

public class GameResult {

    private final List<String> result;

    private GameResult(List<String> result) {
        this.result = result;
    }

    //복사본을 리턴한다. unmodifiable이므로 안전.
    public List<String> getResult() {
        return List.copyOf(result);
    }

    public static GameResult from(List<String> result) {
        return new GameResult(result);
    }
}

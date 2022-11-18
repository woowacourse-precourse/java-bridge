package bridge.dto;

import bridge.constant.ViewStatus;

import java.util.List;

public class GameResult {

    private final List<String> result;
    private final ViewStatus nextViewStatus;

    private GameResult(List<String> result, ViewStatus nextViewStatus) {
        this.result = result;
        this.nextViewStatus = nextViewStatus;
    }

    //복사본을 리턴한다. unmodifiable이므로 안전.
    public List<String> getResult() {
        return List.copyOf(result);
    }

    public ViewStatus getNextViewStatus() {
        return this.nextViewStatus;
    }

    public static GameResult of(List<String> result, ViewStatus nextViewStatus) {
        return new GameResult(result, nextViewStatus);
    }
}

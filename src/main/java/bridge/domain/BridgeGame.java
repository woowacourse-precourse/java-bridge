package bridge.domain;

import java.util.List;

public class BridgeGame {
    private final Result result;
    private int count;

    public BridgeGame(List<String> answer) {
        this(new Result(answer));
    }

    public BridgeGame(Result result) {
        this.result = result;
        count = 1;
    }

    public void move(String place) {
        result.add(place);
    }

    public void retry() {
        increase();
        result.clear();
    }

    private void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public Result getResult() {
        return result;
    }
}

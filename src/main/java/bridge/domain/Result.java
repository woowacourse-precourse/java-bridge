package bridge.domain;

import java.util.List;

public class Result {

    private final List<String> bridge;
    private final boolean survive;
    private final boolean victory;

    public Result(List<String> bridge, boolean survive, boolean victory) {
        this.bridge = bridge;
        this.survive = survive;
        this.victory = victory;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isSurvive() {
        return survive;
    }

    public boolean isVictory() {
        return victory;
    }
}

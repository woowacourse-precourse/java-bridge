package bridge.domain;

public class GameResult {

    public final String result;
    public final int totalTry;

    public GameResult(String result, int totalTry) {
        this.result = result;
        this.totalTry = totalTry;
    }

    public String getResult() {
        return result;
    }

    public int getTotalTry() {
        return totalTry;
    }

}

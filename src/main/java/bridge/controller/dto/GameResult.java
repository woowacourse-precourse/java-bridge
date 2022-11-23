package bridge.controller.dto;

public class GameResult {

    private String map;
    private String result;

    public GameResult(String map, String result) {
        this.map = map;
        this.result = result;
    }

    public String getMap() {
        return map;
    }

    public String getResult() {
        return result;
    }
}

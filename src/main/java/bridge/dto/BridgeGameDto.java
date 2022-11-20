package bridge.dto;

import java.util.List;

public class BridgeGameDto {

    private List<String> bridge;
    private List<String> route;
    private int countOfTry;

    public BridgeGameDto(List<String> bridge, List<String> route, int countOfRetry) {
        this.bridge = bridge;
        this.route = route;
        this.countOfTry = countOfRetry;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getRoute() {
        return route;
    }

    public int getCountOfTry() {
        return countOfTry;
    }
}

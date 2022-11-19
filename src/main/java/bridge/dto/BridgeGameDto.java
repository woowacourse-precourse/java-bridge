package bridge.dto;

import java.util.List;

public class BridgeGameDto {

    private List<String> bridge;
    private List<String> route;

    public BridgeGameDto(List<String> bridge, List<String> route) {
        this.bridge = bridge;
        this.route = route;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getRoute() {
        return route;
    }
}

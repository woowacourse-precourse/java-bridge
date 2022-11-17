package bridge.dto;

import java.util.List;

public class CurrentPositionDto {

    private List<String> bridge;

    private List<String> moveHistory;

    public CurrentPositionDto(List<String> bridge, List<String> moveHistory) {
        this.bridge = bridge;
        this.moveHistory = moveHistory;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMovingHistory() {
        return moveHistory;
    }
}

package bridge.dto;


import bridge.domain.MovingResults;

import java.util.List;

public class MovingResultsDto {
    private final MovingResults upBridge;
    private final MovingResults downBridge;

    public MovingResultsDto(MovingResults upBridge, MovingResults downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public List<MovingResults> get() {
        return List.of(upBridge, downBridge);
    }
}

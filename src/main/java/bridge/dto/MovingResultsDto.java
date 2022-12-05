package bridge.dto;


import bridge.domain.MovingResults;

import java.util.List;
import java.util.stream.Stream;

public class MovingResultsDto {
    private final MovingResults upBridge;
    private final MovingResults downBridge;

    public MovingResultsDto(MovingResults upBridge, MovingResults downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    public List<MovingResults> getMovingResults() {
        return List.of(upBridge, downBridge);
    }
}

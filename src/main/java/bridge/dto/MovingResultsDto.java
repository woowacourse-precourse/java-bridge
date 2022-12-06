package bridge.dto;


import bridge.domain.MovingResult;
import bridge.domain.MovingResults;

import java.util.List;

public class MovingResultsDto {
    private final List<MovingResult> upBridge;
    private final List<MovingResult> downBridge;

    public MovingResultsDto(MovingResults upBridge, MovingResults downBridge) {
        this.upBridge = upBridge.getResults();
        this.downBridge = downBridge.getResults();
    }

    public List<List<MovingResult>> getResult() {
        return List.of(upBridge, downBridge);
    }
}

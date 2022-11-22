package bridge.dto;

import bridge.Direction;

public class BridgeGameDto {
    public int currentPosition = -1;
    public int totalTrial = 0;
    public Direction direction = null;

    public BridgeGameDto(int currentPosition, int totalTrial, Direction direction) {
        this.currentPosition = currentPosition;
        this.totalTrial = totalTrial;
        this.direction = direction;
    }
}

package bridge.dto;

public class BridgeGameDto {
    public int currentPosition = -1;
    public int totalTrial = 0;
    public String direction = null;

    public BridgeGameDto(int currentPosition, int totalTrial, String direction) {
        this.currentPosition = currentPosition;
        this.totalTrial = totalTrial;
        this.direction = direction;
    }
}

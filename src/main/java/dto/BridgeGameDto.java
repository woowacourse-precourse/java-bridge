package dto;

public class BridgeGameDto {
    public int currentPosition = -1;
    public int totalTrial = 0;

    public BridgeGameDto(int currentPosition, int totalTrial) {
        this.currentPosition = currentPosition;
        this.totalTrial = totalTrial;
    }
}

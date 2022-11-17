package bridge.service.dto;

public class BridgeSpaceDto {
    private final String movingSpace;

    public BridgeSpaceDto(String movingSpace) {
        this.movingSpace = movingSpace;
    }

    public String getMovingSpace() {
        return movingSpace;
    }
}

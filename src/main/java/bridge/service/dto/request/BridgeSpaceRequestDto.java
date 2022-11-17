package bridge.service.dto.request;

public class BridgeSpaceRequestDto {
    private final String movingSpace;

    public BridgeSpaceRequestDto(String movingSpace) {
        this.movingSpace = movingSpace;
    }

    public String getMovingSpace() {
        return movingSpace;
    }
}

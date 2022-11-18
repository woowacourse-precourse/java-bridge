package bridge.service.dto.request;

public class PlayerMovementRequestDto {
    private final String movingSpace;

    public PlayerMovementRequestDto(String movingSpace) {
        this.movingSpace = movingSpace;
    }

    public String getMovingSpace() {
        return movingSpace;
    }
}

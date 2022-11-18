package bridge.service.dto.request;

public class PlayerMovementRequestDto {
    private final String movePlayer;

    public PlayerMovementRequestDto(String movePlayer) {
        this.movePlayer = movePlayer;
    }

    public String getMovePlayer() {
        return movePlayer;
    }
}

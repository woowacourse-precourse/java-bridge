package bridge.data.dto.responseDto;

public class GameInitResponseDto {

    private final String sessionId;

    public GameInitResponseDto(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

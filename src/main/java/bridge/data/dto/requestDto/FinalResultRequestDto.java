package bridge.data.dto.requestDto;

public class FinalResultRequestDto {

    private final String sessionId;

    public FinalResultRequestDto(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

package bridge.data.dto.requestDto;

import bridge.type.InGameCommandType;

public class InGameCommandRequestDto {

    private final InGameCommandType command;
    private String sessionId;

    public InGameCommandRequestDto(InGameCommandType command) {
        this.command = command;
    }

    public InGameCommandType getCommand() {
        return command;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

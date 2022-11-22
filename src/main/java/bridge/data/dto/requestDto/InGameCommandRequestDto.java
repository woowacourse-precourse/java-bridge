package bridge.data.dto.requestDto;

import bridge.type.InGameCommandType;

public class InGameCommandRequestDto {

    private final InGameCommandType command;
    private final String sessionId;

    public InGameCommandRequestDto(InGameCommandType command, String sessionId) {
        this.command = command;
        this.sessionId = sessionId;
    }

    public InGameCommandType getCommand() {
        return command;
    }

    public String getSessionId() {
        return sessionId;
    }
}

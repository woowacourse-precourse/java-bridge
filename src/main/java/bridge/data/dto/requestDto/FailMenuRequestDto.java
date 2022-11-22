package bridge.data.dto.requestDto;

import bridge.type.FailMenuCommandType;

public class FailMenuRequestDto {

    private final FailMenuCommandType command;
    private final String sessionId;

    public FailMenuRequestDto(FailMenuCommandType command, String sessionId) {
        this.command = command;
        this.sessionId = sessionId;
    }

    public FailMenuCommandType getCommand() {
        return command;
    }

    public String getSessionId() {
        return sessionId;
    }
}

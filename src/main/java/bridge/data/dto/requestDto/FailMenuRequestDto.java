package bridge.data.dto.requestDto;

import bridge.type.FailMenuCommandType;

public class FailMenuRequestDto {

    private final FailMenuCommandType command;
    private String sessionId;

    public FailMenuRequestDto(FailMenuCommandType command) {
        this.command = command;
    }

    public FailMenuCommandType getCommand() {
        return command;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

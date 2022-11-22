package bridge.data.dto.responseDto;

import bridge.type.FailMenuCommandType;

public class FailMenuResponseDto {

    private final FailMenuCommandType command;

    public FailMenuResponseDto(FailMenuCommandType command) {
        this.command = command;
    }

    public boolean isRetry() {
        return command == FailMenuCommandType.RETRY;
    }

    public boolean isQuit() {
        return command == FailMenuCommandType.QUIT;
    }
}

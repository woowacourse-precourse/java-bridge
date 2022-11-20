package bridge.domain.bridge;

import bridge.domain.Command;
import bridge.domain.Message;

public class BridgeCommand {
    private String command;

    public BridgeCommand(String s) {
        validate(s);
        this.command = s;
    }

    public boolean getIsRetry() {
        return Command.getBySymbol(this.command).getIsRetry();
    }

    private void validate(String s) {
        if (!(s.equals("R") || s.equals("Q"))) {
            System.out.printf(Message.ERROR_COMMAND_OUT_OF_RANGE.get());
            throw new IllegalArgumentException();
        }
    }
}

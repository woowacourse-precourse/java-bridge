package bridge.domain.game;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeGameCommand {
    RETRY("R"),
    QUIT("Q");
    
    private final String command;
    
    BridgeGameCommand(String command) {
        this.command = command;
    }
    
    public String getCommand() {
        return command;
    }
    
    public static boolean isContain(String command) {
        return Arrays.stream(BridgeGameCommand.values()).map(BridgeGameCommand::getCommand).collect(Collectors.toList())
                .contains(command);
    }
}

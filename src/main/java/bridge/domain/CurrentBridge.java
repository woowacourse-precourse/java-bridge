package bridge.domain;

import java.util.List;

public class CurrentBridge {

    private final List<String> currentCommand;

    public CurrentBridge(List<String> currentCommand) {
        this.currentCommand = currentCommand;
    }

    public String getCurrentCommand(int phase) {
        return currentCommand.get(phase);
    }

    public void addCurrentCommand(String command) {
        currentCommand.add(command);
    }

    public int getCurrentPhase() {
        return currentCommand.size();
    }

    public void removeCurrentCommand() {
        currentCommand.remove(currentCommand.size() - 1);
    }
}

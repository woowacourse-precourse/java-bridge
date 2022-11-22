package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Command> commands;
    private int attemptCount;

    public Player() {
        this.commands = new ArrayList<>();
        this.attemptCount = 1;
    }

    //객체가 행동하도록 메서드 구현.
    public void retry() {
        this.commands = new ArrayList<>();
        this.attemptCount++;
    }

    public void enterCommand(Command command) {
        this.commands.add(command);
    }

    public int checkCurrentLevel() {
        return this.commands.size();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public boolean checkIfMaxCount(Bridge bridge) {
        int maxSize = bridge.getAnswers().size();
        if (this.commands.size() == maxSize) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}

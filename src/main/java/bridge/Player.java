package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Command> commands;
    private int attemptCount;

    public Player() {
        this.commands = new ArrayList<>();
        this.attemptCount = 0;
    }

    //객체가 행동하도록 메서드 구현.
    public void retry() {
        this.attemptCount++;
    }

}

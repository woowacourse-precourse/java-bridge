package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int bridgeSize;
    private List<String> movingCommands = new ArrayList<>();
    private int runCounts = 0;

    public int getBridgeSize() {
        return bridgeSize;
    }

    public List<String> getMovingCommand() {
        return movingCommands;
    }

    public void setBridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public void addMovingCommands(String movingCommand) {
        this.movingCommands.add(movingCommand);
    }

    public void increaseRunCounts() {
        this.runCounts++;
    }

    public void clearMovingCommand() {
        movingCommands.clear();
    }
}

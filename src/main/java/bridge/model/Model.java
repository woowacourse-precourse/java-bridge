package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static int bridgeSize;
    private static List<String> movingCommand = new ArrayList<>();

    public static int getBridgeSize() {
        return bridgeSize;
    }

    public static List<String> getMovingCommand() {
        return movingCommand;
    }

    public static void setBridgeSize(int bridgeSize) {
        Model.bridgeSize = bridgeSize;
    }

    public static void setMovingCommand(List<String> movingCommand) {
        Model.movingCommand = movingCommand;
    }

    public static void clearMovingCommand() {
        movingCommand.clear();
    }
}

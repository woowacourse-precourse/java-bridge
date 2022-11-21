package bridge;

import java.util.List;

public enum Site {
    UP("U"),
    DOWN("D");

    String movement_command;

    Site(String movement_command) {
        this.movement_command = movement_command;
    }

    public boolean saveMovementCommandInBridge(List<String> bridge) {
        return bridge.add(movement_command);
    }

    public boolean isSameCommand(String movement_command){
        return this.movement_command.equals(movement_command);
    }

}

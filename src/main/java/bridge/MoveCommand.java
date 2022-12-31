package bridge;

import java.util.ArrayList;
import java.util.List;

public enum MoveCommand {
    TOP(1, "U"),
    BOTTOM(0, "D");

    private final int randomNumber;
    private final String moveCommand;

    MoveCommand(int randomNumber, String moveCommand) {
        this.randomNumber = randomNumber;
        this.moveCommand = moveCommand;
    }

    public static String getMoveCommandByRandomNumber(int randomNumber) {
        for (MoveCommand type : MoveCommand.values()) {
            if (type.getRandomNumber() == randomNumber) {
                return type.getMoveCommand();
            }
        }
        return "";
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public String getMoveCommand() {
        return moveCommand;
    }

    public static List<String> getMoveCommands() {
        List<String> commands = new ArrayList<>();
        for (MoveCommand type : MoveCommand.values()) {
            commands.add(type.getMoveCommand());
        }
        return commands;
    }
}
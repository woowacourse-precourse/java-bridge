package bridge.constant.command;

import bridge.constant.message.GameErrorMessage;

public interface Command {
    int getKey();

    String getValue();

    static String convertKeyToValue(int key, Class<? extends Command> commandClass) {
        Command[] enumCommands = commandClass.getEnumConstants();
        for (Command command : enumCommands) {
            if (key == command.getKey()) {
                return command.getValue();
            }
        }
        throw new IllegalStateException(GameErrorMessage.NO_SUCH_COMMAND.getMessage());
    }
}

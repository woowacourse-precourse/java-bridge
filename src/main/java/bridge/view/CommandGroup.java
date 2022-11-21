package bridge.view;

import bridge.config.ErrorMessageConstant;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum CommandGroup {
    MOVE("이동할 칸", Arrays.asList(CommandType.MOVE_TO_UP, CommandType.MOVE_TO_DOWN)),
    GAME_CONTROL("게임 진행 선택", Arrays.asList(CommandType.GAME_RETRY, CommandType.GAME_QUIT));

    private final String description;
    private final List<CommandType> commands;

    CommandGroup(String description, List<CommandType> commands) {
        this.description = description;
        this.commands = commands;
    }

    public static CommandGroup findByCommandType(CommandType commandType) throws NoSuchElementException {
        return Arrays.stream(CommandGroup.values())
                .filter(commandGroup -> commandGroup.hasCommandCode(commandType))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(ErrorMessageConstant.COMMAND_GROUP_NOT_FOUND));
    }

    private boolean hasCommandCode(CommandType commandType) {
        return commands.stream()
                .anyMatch(command -> command == commandType);
    }
}

package bridge.view;

import bridge.config.ErrorMessageConstant;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 명령어 그룹을 관리하는 열거형
 */
public enum CommandGroup {
    MOVE("이동할 칸", Arrays.asList(CommandType.MOVE_TO_UP, CommandType.MOVE_TO_DOWN)),
    GAME_CONTROL("게임 진행 선택", Arrays.asList(CommandType.GAME_RETRY, CommandType.GAME_QUIT));

    private final String description;
    private final List<CommandType> commands;

    CommandGroup(String description, List<CommandType> commands) {
        this.description = description;
        this.commands = commands;
    }

    /**
     * 명령어로 그룹을 검색
     * @param commandType 명령어
     * @return 명령어가 속한 그룹
     * @throws NoSuchElementException 그룹을 찾지 못한 경우 예외 발생
     */
    public static CommandGroup findByCommandType(CommandType commandType) throws NoSuchElementException {
        return Arrays.stream(CommandGroup.values())
                .filter(commandGroup -> commandGroup.hasCommandCode(commandType))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(ErrorMessageConstant.COMMAND_GROUP_NOT_FOUND));
    }

    /**
     * 명령어 그룹에 포함되어 있는지 반환
     * @param commandType 찾을 명령어
     * @return 포함 여부
     */
    private boolean hasCommandCode(CommandType commandType) {
        return commands.stream()
                .anyMatch(command -> command == commandType);
    }
}

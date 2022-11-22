package bridge.view;

import bridge.config.ErrorMessageConstant;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandType {
    MOVE_TO_UP("U"),
    MOVE_TO_DOWN("D"),
    GAME_RETRY("R"),
    GAME_QUIT("Q");

    private static final Map<String, String> COMMAND_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(CommandType::getCommand, CommandType::name))
    );

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    /**
     * 입력된 문자열을 이용해 해당하는 명령어 정보 찾기
     * @param command 입력된 문자열
     * @return 명령어
     * @throws NoSuchElementException 해당하는 명령어가 없을 경우 예외 발생
     */
    public static CommandType of(final String command) throws NoSuchElementException {
        String name = COMMAND_MAP.get(command);
        if (name == null) {
            throw new NoSuchElementException(ErrorMessageConstant.COMMAND_NOT_FOUND);
        }
        return CommandType.valueOf(name);
    }
}

package bridge.domain.gameOver;

public class GameRestartOrQuitValidator {
    private static final String EMPTY_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작 또는 종료 여부가 입력되지 않았습니다.";
    private static final String GAME_COMMAND_LENGTH_OUT_OF_RANGE_ERROR_MEESAGE = "[ERROR] 게임 재시작 또는 종료 여부는 문자 1글자만 입력되어야 합니다.";
    private static final String NOT_RESTART_AND_QUIT_CHARACTER_ERROR_MESSAGE = "[ERROR] 입력된 값은 문자 R과 Q가 아닙니다. 게임 재시작 또는 종료 여부로 R 또는 Q만 입력해주세요.";

    private static final int GAME_COMMAND_LENGTH_LIMIT = 1;
    private static final String GAME_COMMAND_RESTART = "R";
    private static final String GAME_COMMAND_QUIT = "Q";

    public static void validate(String restartOrQuitCommand) {
        validateEmptyGameCommand(restartOrQuitCommand);

        validateGameCommandLengthRange(restartOrQuitCommand);

        validateNotRestartAndDownCharacter(restartOrQuitCommand);
    }

    public static void validateEmptyGameCommand(String restartOrQuitCommand) {
        if (restartOrQuitCommand.isEmpty() || restartOrQuitCommand.equals(null)) {
            throw new IllegalArgumentException(EMPTY_GAME_COMMAND_ERROR_MESSAGE);
        }
    }

    public static void validateGameCommandLengthRange(String restartOrQuitCommand) {
        if (restartOrQuitCommand.length() != GAME_COMMAND_LENGTH_LIMIT) {
            throw new IllegalArgumentException(GAME_COMMAND_LENGTH_OUT_OF_RANGE_ERROR_MEESAGE);
        }
    }

    public static void validateNotRestartAndDownCharacter(String restartOrQuitCommand) {
        if (!restartOrQuitCommand.equals(GAME_COMMAND_RESTART) && !restartOrQuitCommand.equals(GAME_COMMAND_QUIT)) {
            throw new IllegalArgumentException(NOT_RESTART_AND_QUIT_CHARACTER_ERROR_MESSAGE);
        }
    }
}
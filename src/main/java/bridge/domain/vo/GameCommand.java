package bridge.domain.vo;

public class GameCommand {
    private static final String GAME_COMMAND_LENGTH_IS_NOT_ONE = "게임 재시작 여부는 문자 1개를 입력해주세요.";
    private static final String RETRY = "R";
    private static final String END = "Q";
    private static final String GAME_COMMAND_IS_NOT_R_AND_Q = "게임 재시작 여부는 R 또는 Q로 입력해주세요.";

    private final String gameCommand;

    public static GameCommand createGameCommand(String gameCommand) {
        return new GameCommand(gameCommand);
    }

    public GameCommand(String gameCommand){
        validateGameCommand(gameCommand);
        this.gameCommand = gameCommand;
    }

    public void validateGameCommand(String gameCommand) {
        if (gameCommand.length() != 1) {
            throw new IllegalArgumentException(GAME_COMMAND_LENGTH_IS_NOT_ONE);
        }
        if (!gameCommand.equals(RETRY) && !gameCommand.equals(END)) {
            throw new IllegalArgumentException(GAME_COMMAND_IS_NOT_R_AND_Q);
        }
    }
}

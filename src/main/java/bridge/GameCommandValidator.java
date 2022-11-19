package bridge;

import java.util.List;

public class GameCommandValidator implements InputValidator {
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R(재시작), Q(종료) 중 하나를 입력해야 합니다.";

    @Override
    public void validateInput(String input) {
        List<String> gameCommandOptions = List.of(RETRY, QUIT);
        if(!gameCommandOptions.contains(input)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }
}

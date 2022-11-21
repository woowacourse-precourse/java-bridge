package bridge.model.valid;

import bridge.model.utils.GameCommands;

import java.util.List;

public class GameCommandValidator implements InputValidator {
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R(재시작), Q(종료) 중 하나를 입력해야 합니다.";

    @Override
    public void validateInput(String input) {
        List<String> gameCommandOptions = List.of(GameCommands.RETRY, GameCommands.QUIT);
        if(!gameCommandOptions.contains(input)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.format("< GameCommandValidator options=%s >", List.of(GameCommands.RETRY, GameCommands.QUIT));
    }
}

package bridge.validate;

import bridge.value.GameCommand;
import java.util.Arrays;

public class GameValidation {

    public static void validateGameCommand(String command) {
        Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.getCharacter().equals(command))
                .findAny().orElseThrow(() -> new IllegalArgumentException("입력한 게임 제어 문자가 존재하지 않습니다."));
    }

    public static void validateGameSuccess(boolean isGameSuccess) {
        if (isGameSuccess) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }
    }
}

package bridge.view.input;

import bridge.domain.value.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ViewMessages.GAME_COMMAND;

public class GameCommandInput implements Input<GameCommand> {
    @Override
    public GameCommand read() {
        System.out.println(GAME_COMMAND);
        return new GameCommand(Console.readLine());
    }
}

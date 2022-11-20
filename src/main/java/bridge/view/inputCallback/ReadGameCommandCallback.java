package bridge.view.inputCallback;

import bridge.view.GameCommand;
import camp.nextstep.edu.missionutils.Console;

public class ReadGameCommandCallback implements ReadLineCallback<GameCommand> {
    private static final String GAME_COMMAND_INPUT_PROMPT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    @Override
    public GameCommand repeatToRead() {
        System.out.println(GAME_COMMAND_INPUT_PROMPT);
        return GameCommand.of(Console.readLine());
    }
}

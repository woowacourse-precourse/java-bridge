package bridge.view.inputCallback;

import camp.nextstep.edu.missionutils.Console;

public class ReadGameCommandCallback implements ReadLineCallback<String> {
    private static final String GAME_COMMAND_INPUT_PROMPT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String INVALID_INPUT = "게임 재시도 여부가 올바르지 않습니다.";

    @Override
    public String repeatToRead() {
        System.out.println(GAME_COMMAND_INPUT_PROMPT);
        String line = Console.readLine();
        validate(line);
        return line;
    }

    private void validate(String line) {
        if (!line.equals("Q") && !line.equals("R")) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}

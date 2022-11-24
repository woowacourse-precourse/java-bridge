package bridge.view.inputCallback;

import camp.nextstep.edu.missionutils.Console;

public class ReadPositionToMoveCallback implements ReadLineCallback<String> {
    private static final String MOVE_INPUT_PROMPT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INVALID_INPUT = "입력값이 올바르지 않습니다.";

    @Override
    public String repeatToRead() {
        System.out.println(MOVE_INPUT_PROMPT);
        String position = Console.readLine();
        validate(position);
        return position;
    }

    private void validate(String position) {
        if (!position.equals("U") && !position.equals("D")) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}

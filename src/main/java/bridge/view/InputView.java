package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n" + "다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";

    public int readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);

        int size = convertStringToInt(Console.readLine());

        System.out.println();
        return size;
    }

    public String readMoving() {
        System.out.println(MOVING_INPUT_MESSAGE);

        String movingInput = Console.readLine();
        return movingInput;
    }

    public String readGameCommand() {
        System.out.println(COMMAND_INPUT_MESSAGE);

        String command = Console.readLine();
        return command;
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}

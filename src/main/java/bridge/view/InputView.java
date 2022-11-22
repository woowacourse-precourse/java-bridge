package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Validator.*;

public class InputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = System.lineSeparator() + "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        try {
            return Integer.parseInt(validateBridgeSize(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readBridgeSize();
    }

    public String readMoving() {
        System.out.println(MOVE_INPUT_MESSAGE);
        try {
            return validateMoveInput(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readMoving();
    }

    public String readGameCommand() {
        System.out.println(RETRY_INPUT_MESSAGE);
        try {
            return validateCommand(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readGameCommand();
    }
}

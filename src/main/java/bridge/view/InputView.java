package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String PUT_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 내가 만든함수 : guideStart
     */
    public static void guideStart() {
        OutputView.printGuide(START_MESSAGE);
        OutputView.printGuide("");
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    /**
     * size를 입력 받는다.
     */
    public static int readBridgeSize() {
        OutputView.printGuide(PUT_SIZE);
        String command = Console.readLine();
        OutputView.printGuide("");
        validateNumber(command);
        validateRange(Integer.parseInt(command));
        return Integer.parseInt(command);
    }

    private static void validateNumber(String command) {
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static void validateRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        OutputView.printGuide(PUT_MOVING);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printGuide(PUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}

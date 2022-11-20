package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    public static void validateBridgeSize(String bridgeSize) {
        if (isNotNumber(bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
        if (isLengthOutOfRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isNotNumber(String bridgeSize) {
        return !bridgeSize.matches("^-?[0-9]+$");
    }

    private static boolean isLengthOutOfRange(int bridgeSize) {
        return bridgeSize < 3 || bridgeSize > 20;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    public static void validateMoving(String moving) {
        if (isNotUD(moving)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸에 대한 입력은 'U' 또는 'D'여야 합니다.");
        }
    }

    private static boolean isNotUD(String moving) {
        return !moving.equals("U") && !moving.equals("D");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);

        return gameCommand;
    }

    private static void validateGameCommand(String gameCommand) {
        if(isNotRQ(gameCommand)){
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부에 대한 입력은 'R' 또는 'Q'여야 합니다.");
        }
    }

    private static boolean isNotRQ(String gameCommand) {
        return !gameCommand.equals("R") && !gameCommand.equals("Q");
    }
}

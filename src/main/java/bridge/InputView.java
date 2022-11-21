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
        String bridgeSizeString = Console.readLine();
        int bridgeSize = 0;
        bridgeSize = checkBridgeSizeString(bridgeSizeString);
        return bridgeSize;
    }

    private static int checkBridgeSizeString(String bridgeSizeString) {
        int bridgeSize = stringToInt(bridgeSizeString);
        if (!(bridgeSize >= 3 || bridgeSize <= 20))
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해주세요.");
        return bridgeSize;
    }

    private static int stringToInt(String bridgeSizeString) {
        try {
            int result = Integer.parseInt(bridgeSizeString);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moveInput = "";
        moveInput = Console.readLine();
        checkMoveInput(moveInput);
        return moveInput;
    }

    private static void checkMoveInput(String moveInput) {
        if (!(moveInput.equals("U") || moveInput.equals("D")))
            throw new IllegalArgumentException("[ERROR] 위 : U 또는 아래 : D 를 입력해주세요.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String gameInput = "";
        gameInput = Console.readLine();
        checkGameInput(gameInput);
        return gameInput;
    }

    private static void checkGameInput(String gameInput) {
        if (!(gameInput.equals("R") || gameInput.equals("Q")))
            throw new IllegalArgumentException("[ERROR] 재시작 : R 또는 종료 : Q 를 입력해주세요.");
    }

}

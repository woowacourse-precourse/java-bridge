package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        String userBridgeSizeInput = Console.readLine();
        return userBridgeSizeInput;
    }

    public void userBridgeSizeInputValidation (String userBridgeSizeInput) {
        try {
            Integer.parseInt(userBridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다");
        }
    }

    public void userBridgeSizeValidation(int userBridgeSize) {
        if (userBridgeSize < 3 || 20 < userBridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userMovingInput = Console.readLine();
        return userMovingInput;
    }

    public void userMovingInputValidation (String userMovingInput) {
        if (!userMovingInput.equals("U") && !userMovingInput.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String userGameCommandInput = Console.readLine();
        return userGameCommandInput;
    }

    public void userGameCommandValidation (String userGameCommandInput) {
        if (!userGameCommandInput.equals("R") && !userGameCommandInput.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야 합니다.");
        }
    }
}

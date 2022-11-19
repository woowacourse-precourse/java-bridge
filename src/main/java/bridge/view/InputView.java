package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(INPUT_SIZE);
            String size = Console.readLine();
            sizeValidate(size);
            return Integer.valueOf(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void sizeValidate(String size) {
        if (!size.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 들어올 수 있습니다.");
        }
        if (Integer.valueOf(size) < 3 || Integer.valueOf(size) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_MOVE);
            String move = Console.readLine();
            moveValidate(move);
            return move;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private void moveValidate(String move) {
        if (!move.matches("[UD]")) {
            throw new IllegalArgumentException("[ERROR] 위로 이동하려면 U, 아래로 이동하려면 D를 입력해주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(INPUT_RETRY);
            String gameCommand = Console.readLine();
            gameCommandValidate(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void gameCommandValidate(String gameCommand) {
        if (!gameCommand.matches("[RQ]")) {
            throw new IllegalArgumentException("[ERROR] 다시 시작하려면 R, 게임을 종료하려면 Q를 입력해주세요.");
        }
    }
}

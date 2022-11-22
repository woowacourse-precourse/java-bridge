package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    StringBuilder sb;
    static final String ASK_BRIDGE_LONG = "다리의 길이를 입력해주세요.";
    static final String ASK_MOVE_BRIDGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String ASK_RETRY = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String MOVE_COMMAND = "DU";
    static final String RETRY_COMMAND = "RQ";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(ASK_BRIDGE_LONG);
        return readInt(readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(ASK_MOVE_BRIDGE);
        return vaildMoveCommand(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(ASK_RETRY);
        return vaildRetryCommand(readLine());
    }

    static private int readInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(Error.ERROR_NOT_NUMBER.getMessage());
            return readBridgeSize();
        }
    }


    private static String vaildMoveCommand(String move) {
        try {
            if (!MOVE_COMMAND.contains(move)) {
                throw new IllegalArgumentException(Error.ERROR_NOT_COMMAD.getMessage());
            }
            return move;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readMoving();
        }
    }

    private static String vaildRetryCommand(String command) {
        try {
            if (!RETRY_COMMAND.contains(command)) {
                throw new IllegalArgumentException(Error.ERROR_NOT_COMMAD.getMessage());
            }
            return command;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readGameCommand();
        }
    }
}

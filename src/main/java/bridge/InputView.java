package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static int BRIDGE_SIZE;
    public static String MOVING;
    public static String GAME_COMMAND;

    public static String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static String ERROR_MOVING = "[ERROR] 이동할 칸은 U 또는 D여야 합니다.";
    public static String ERROR_RESTART = "[ERROR] 게임 다시 시도 여부는 R 또는 Q여야 합니다.";

    public InputView() {
        System.out.println("다리 건너기 게임을 시작합니다." + "\n");
    }

    static void errorBridgeSize() {
        System.out.println(ERROR_BRIDGE_SIZE);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

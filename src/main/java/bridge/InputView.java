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

        System.out.println("다리의 길이를 입력해주세요.");
        BRIDGE_SIZE = Integer.parseInt(Console.readLine());
        if(!(BRIDGE_SIZE >= 3 && BRIDGE_SIZE <= 20)) {
            throw new IllegalArgumentException();
        }

        return BRIDGE_SIZE;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        MOVING = Console.readLine();
        if(!(MOVING.equals("U") || MOVING.equals("D"))) {
            throw new IllegalArgumentException(ERROR_MOVING);
        }

        return MOVING;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        GAME_COMMAND = Console.readLine();
        if(!(MOVING.equals("R") || MOVING.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_RESTART);
        }

        return GAME_COMMAND;
    }

    public int bridgeSize() {
        return BRIDGE_SIZE;
    }

    public String moveUser() {
        return MOVING;
    }

}

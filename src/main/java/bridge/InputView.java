package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static int bridgeSize;
    public static String inputDirection;
    public static String inputRestart;

    /**
     * 다리의 길이를 입력받는다.
     */
    public static void inputBridgeSize() {
        String inputSize = readLine();
        System.out.println();
        bridgeSize = Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static void inputMovingDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
        inputDirection = readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static void inputGameRestart() {
        System.out.println(Message.ASK_RESTART.getMessage());
        inputRestart = readLine();
    }
}

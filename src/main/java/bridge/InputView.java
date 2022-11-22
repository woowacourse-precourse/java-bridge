package bridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String ENTER_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        int bridgeSize = Integer.parseInt(Console.readLine());
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(ENTER_UP_OR_DOWN);
        String selectMove = Console.readLine();
        return selectMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(RESTART_GAME);
        return Console.readLine();
    }
}

package bridge.view;

import bridge.util.BridgeUtil;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String square = Console.readLine();
        if(!(square.equals(BridgeUtil.UP) || square.equals(BridgeUtil.DOWN))){
            System.out.println(ExceptionMessage.isProperMsg());
            return readMoving();
        }
        return square;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String reply = Console.readLine();
        if(!(reply.equals(BridgeUtil.RESTART) || reply.equals(BridgeUtil.QUIT))){
            System.out.println(ExceptionMessage.isReplyMsg());
            return readGameCommand();
        }
        return reply;
    }
}

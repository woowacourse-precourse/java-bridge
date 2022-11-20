package bridge.view;

import bridge.view.util.CheckUtil;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리 길이를 입력해주세요.";
    private static final String INPUT_READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String ERROR_BRIDGE_SIZE_OVER = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        try{
            int input = Integer.valueOf(Console.readLine());
            CheckUtil.checkInputBridgeSize(input,ERROR_BRIDGE_SIZE_OVER);
            return input;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return null;
    }
}

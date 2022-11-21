package bridge.View;

import javax.swing.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String Input_Bridge_length = "다리의 길이를 입력해주세요.";
    private static final String Input_Bridge_move = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String Input_Game_Command = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(Input_Bridge_length);
        // 에러처리?
        return Integer.parseInt(readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(Input_Bridge_move);
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(Input_Game_Command);
        return readLine();
    }
}

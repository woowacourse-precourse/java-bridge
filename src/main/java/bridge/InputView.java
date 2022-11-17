package bridge;

import java.util.List;


import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */

    private static final int[] Min_Value_MaxVlaue = {};
//    private static final int Max_Value = 20;


    public static int readBridgeSize(){
        String input = readLine();
        int inputToint = Integer.parseInt(input);
        if(inputToint > 2 && inputToint < 21){

            return inputToint;
        }
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

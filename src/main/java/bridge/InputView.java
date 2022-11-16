package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static String redBridgeSize = "다리의 길이를 입력해주세요.";
    private static String redBridgeSizeError = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(redBridgeSize);
        int result = Integer.parseInt(Console.readLine());
        if(result < 3 || result > 20){
            System.out.println(redBridgeSizeError);
            throw new IllegalArgumentException();
        }
        return result;
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

package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String strA = Console.readLine();
        try {
            int integerA = Integer.parseInt(strA);
            return integerA;
        } catch (IllegalArgumentException e) { // 다리 길이가 숫자가 아닌 경우
            System.out.println("[ERROR] 다리 길이는 숫자로 입력하세요.");
            return 0;
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() { // U or D
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() { // Q or R
        return Console.readLine();
    }
}

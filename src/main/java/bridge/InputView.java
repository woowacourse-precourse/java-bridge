package bridge;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static String Regex = "[^0-9]";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String InputVal = Console.readLine();
        try {
            int BridgeSize = Integer.parseInt(InputVal);
            if (BridgeSize < 3 || BridgeSize > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return -1;
        }
        return Integer.parseInt(InputVal);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String InputVal = Console.readLine();
        try {
            if ( InputVal.length() > 1)
                throw new IllegalArgumentException("[ERROR] 길이가 2 이상입니다.");
            if (!InputVal.contains("U") && !InputVal.contains("D")) {
                throw new IllegalArgumentException("[ERROR] U,D 이외의 값을 입력하였습니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U,D 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return InputVal;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String InputVal = Console.readLine();
        try {
            if ( InputVal.length() > 1)
                throw new IllegalArgumentException("[ERROR] 길이가 2 이상입니다.");
            if (!InputVal.contains("R") && !InputVal.contains("Q")) {
                throw new IllegalArgumentException("[ERROR] R,Q 이외의 값을 입력하였습니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] R,Q 이외의 값을 입력하였습니다.");
            return "EXIT";
        }
        return InputVal;
    }
}

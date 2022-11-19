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
            if (InputVal.replaceAll(Regex, "").length() != InputVal.length()) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }

            if (BridgeSize < 3 || BridgeSize > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            readBridgeSize();
        }
        return Integer.parseInt(InputVal);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String InputVal = Console.readLine();
        try {
            if (((!InputVal.contains("U") && !InputVal.contains("D"))) || InputVal.length() > 1) {
                throw new IllegalArgumentException("[ERROR] U,D 이외의 값을 입력하였습니다.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            readMoving();
        }
        return InputVal;

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String InputVal = Console.readLine();
        if ((InputVal.contains("R") || InputVal.contains("Q")) && InputVal.length()==1) {
            return InputVal;
        }
        throw new IllegalArgumentException("[ERROR] R,Q 이외의 값을 입력하였습니다.");
    }
}

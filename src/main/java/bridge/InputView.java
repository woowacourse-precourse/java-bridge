package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int len = -1;
        String s = readLine();
        String sizerror = sizerror(s);
        if (sizerror.equals("OKEY")) len = Integer.parseInt(s);
        if (!sizerror.equals("OKEY")) System.out.println(sizerror);
        return len;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readLine();
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String startOrExit = readLine();
        return startOrExit;
    }

    public String sizerror(String size) {
        boolean matches = size.matches("[+-]?\\d*(\\.\\d+)?");
        if (!matches) return "[ERROR]";
        return "OKEY";
    }
}

package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int length = Integer.parseInt(readLine());
        return length;
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

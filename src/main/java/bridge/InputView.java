package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        int length = Integer.parseInt(readLine());
        return length;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = readLine();
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String reply = readLine();
        return reply;
    }
}

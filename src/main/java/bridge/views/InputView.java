package bridge.views;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static int inputCount = 0;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String strBridgeSize = readLine();
        return Integer.parseInt(strBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String movingTo = readLine();
        return movingTo;
    }

    public static int readCount() {
        return inputCount += 1;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String GameCommand = readLine();
        return GameCommand;
    }

    public void gameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}

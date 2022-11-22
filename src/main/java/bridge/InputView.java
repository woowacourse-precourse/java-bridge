package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static int num;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        return validBridgeSizeNumber();
    }
    private int validBridgeSizeNumber() {
        while (true) {
            System.out.println("\n" + "다리의 길이를 입력해주세요.");
            String original_size = readLine();
            try {
                int n = Integer.parseInt(original_size);
                validBridgeSize(n);
                return n;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
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

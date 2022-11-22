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

    private void validBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = readLine();
            try {
                validMoving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 이동할 칸 입력은 U 또는 D 로만 가능합니다.");
            }
        }
    }
    private void validMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동 입력은 U 또는 D로만 가능합니다");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

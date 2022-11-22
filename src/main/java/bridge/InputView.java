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
        int Size = 0;
        String size = "";
        while (true) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                size = Console.readLine();
                if (validate(size)) {
                    return Integer.parseInt(size);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }

    public boolean validate(String size) {
        try {
            int Size = Integer.parseInt(size);
            if (Size < 3 || Size > 20) {
                System.out.println("[ERROR] 유효하지 않은 수 입니다.");
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 타입입니다.");
        }
        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userUD = "";
        while (true) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                userUD = Console.readLine();
                if (!(userUD.equals("U") || userUD.equals("D"))) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 값입니다.");
                }
                return userUD;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userRQ = "";
        while (true) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                userRQ = Console.readLine();
                if (!(userRQ.equals("R") || userRQ.equals("Q"))) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 값입니다.");
                }
                return userRQ;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

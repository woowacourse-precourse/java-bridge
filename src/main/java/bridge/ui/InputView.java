package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public final String BRIDGE_SIZE_MENT = "다리의 길이를 입력해주세요";
    public final String MOVING_MENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final String RETRY_MENT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(BRIDGE_SIZE_MENT);
                String s = Console.readLine();
                validateBridgeSize(s);
                return Integer.parseInt(s);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBridgeSize(String s) throws IllegalArgumentException {
        char[] arrCh = s.toCharArray();
        for (char ch : arrCh) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자여야 합니다");
            }
        }
        int winningNum = Integer.parseInt(s);
        if (winningNum < 3 || 20 < winningNum) {
            throw new IllegalArgumentException("[ERROR] 다리 길이의 범위는 3~20입니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(MOVING_MENT);
                String s = Console.readLine();
                validateMoving(s);
                return s;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoving(String s) throws IllegalArgumentException {
        if (!s.equals("D") && !s.equals("U")) {
            throw new IllegalArgumentException("[ERROR] 플레이어는 U(위 칸) 또는 D(아래 칸)으로만 이동할 수 있습니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MENT);
        String s = Console.readLine();
        // validateGameCommand(s);
        return s;
    }
}

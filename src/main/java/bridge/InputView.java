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
        while (true) {
            Integer bridgeSize = Integer.valueOf(Console.readLine());
            System.out.println("입력받은 값 : " + bridgeSize);
            try {
                if (bridgeSize >= 3 && bridgeSize <= 20) {
                    return bridgeSize;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 다리 숫자가 아닙니다.");
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String input = Console.readLine();
            System.out.println("입력받은 값 : " + input);
            try {
                if (input.equals("U") || input.equals("D")) {
                    return input;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 이동 값이 아닙니다.");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            String input = Console.readLine();
            System.out.println("입력받은 값 : " + input);
            try {
                if (input.equals("R") || input.equals("Q")) {
                    return input;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 게임 종료 값이 아닙니다.");
            }
        }
    }
}
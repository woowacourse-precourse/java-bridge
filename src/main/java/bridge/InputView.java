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
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("[ERROR] :: " + e.getMessage());
            readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if(!input.equals("U") && !input.equals("D")) {
            try {
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] :: " + e.getMessage());
                readMoving();
            }
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if(!input.equals("R") && !input.equals("Q")) {
            try {
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] :: " + e.getMessage());
                readMoving();
            }
        }
        return input;
    }
}

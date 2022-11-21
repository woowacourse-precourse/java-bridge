package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        while(true) {
            try {
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 다리는 숫자여야 합니다.");
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        while(true) {
            try {
                String input = Console.readLine();
                validateIsUorD(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 이동 입력은 U또는 D여야 합니다.");
            }
        }
    }

    private void validateIsUorD(String input) throws IllegalArgumentException {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        throw new IllegalArgumentException();
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        while(true) {
            try {
                String input = Console.readLine();
                validateIsQorR(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 재시작 입력은 Q또는 R이어야 합니다.");
            }
        }
    }

    private void validateIsQorR(String input) throws IllegalArgumentException {
        if (input.equals("Q") || input.equals("R")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}

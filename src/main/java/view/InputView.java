package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    //생성자에 예외처리 객체를 넣는다.

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        for (; ; ) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                String sizeInput = Console.readLine();

                if (sizeInput.length() < 1 || sizeInput.length() > 2) {
                    throw new IllegalArgumentException();
                }
                if (!sizeInput.chars().allMatch(ch -> Character.isDigit(ch))) {
                    throw new IllegalArgumentException("[ERROR]");
                }

                int size = Integer.parseInt(sizeInput);

                if (size < 3 || size > 20) {
                    throw new IllegalArgumentException("[ERROR]");
                }

                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        for (; ; ) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String moveInput = Console.readLine();

                if (moveInput.length() != 1) {
                    throw new IllegalArgumentException("[ERROR]");
                }
                if (!(moveInput.equals("U") || (moveInput.equals("D")))) {
                    throw new IllegalArgumentException("[ERROR]");
                }

                return moveInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        for (; ; ) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String retryInput = Console.readLine();

                if (retryInput.length() != 1) {
                    throw new IllegalArgumentException("[ERROR]");
                }
                if (!(retryInput.equals("R") || (retryInput.equals("Q")))) {
                    throw new IllegalArgumentException("[ERROR]");
                }

                return retryInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

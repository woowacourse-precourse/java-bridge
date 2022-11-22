package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                int bridgeSize = Integer.parseInt(Console.readLine());

                validSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

            }
        }
    }

    private void validSize(int bridgeSize) {
        if ((bridgeSize < 3) || (bridgeSize > 20)) {

            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        while (true) {
            try {
                String moving = Console.readLine();

                validChar(moving, "U", "D");
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validChar(String word, String valid1, String valid2) {
        if (!(word.equals(valid1)) && !(word.equals(valid2))) {

            throw new IllegalArgumentException("[ERROR] " + valid1 + "와 " + valid2 + "만 입력가능!");
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        while (true) {
            try {
                String command = Console.readLine();

                validChar(command, "R", "Q");
                return command;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

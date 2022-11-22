package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validation validation = new Validation();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        int bridgeSize = validation.validationNumber(readInteger());

        System.out.println("");

        return bridgeSize;
    }


    public int readInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("올바른 숫자를 정수로 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        while (true) {
            String move = Console.readLine();
            if (validation.validationMoving(move)) {
                return move;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        while (true) {
            String exit = Console.readLine();
            if (validation.validationIsExitCommand(exit)) {
                return exit;
            }
        }
    }
}

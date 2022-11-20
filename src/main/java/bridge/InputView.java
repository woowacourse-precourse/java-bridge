package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * view내부에는 Model에 대한 코드만 있을 수 있고, Controller에 대한 코드가 있어서는 안된다!!
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해 주세요.");
        return Integer.parseInt(Console.readLine()); // 입력에 대한 예외처리를 하여야 한다. 사용자를 믿지 말 것!!
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine(); // 입력에 대한 예외처리를 하여야 한다. 사용자를 믿지 말 것!!
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine(); // 입력에 대한 예외처리를 하여야 한다. 사용자를 믿지 말 것!!
    }
}

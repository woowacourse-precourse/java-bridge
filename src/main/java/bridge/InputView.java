package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Validation.*;

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
        if (NUMERIC.isValid(input)) {
            if (THREE_TO_TWENTY.isValid(input)) {
                return Integer.parseInt(input);
            }
            throw new IllegalArgumentException("[ERROR] 3부터 20까지의 숫자를 입력해주세요.");
        }
        throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if (U_OR_D.isValid(input)) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] U 또는 D 둘 중 하나의 값으로만 입력해주세요.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if (R_OR_Q.isValid(input)) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] R 또는 Q 둘 중 하나의 값으로만 입력해주세요.");
    }
}

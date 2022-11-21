package bridge;
import camp.nextstep.edu.missionutils.Console;

import static bridge.Validation.NUMERIC;
import static bridge.Validation.THREE_TO_TWENTY;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if (NUMERIC.isValid(input)){
            if (THREE_TO_TWENTY.isValid(input)){
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

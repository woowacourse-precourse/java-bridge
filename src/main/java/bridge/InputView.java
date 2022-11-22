/**
 * InputView 클래스에서만
 * camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해
 * 사용자의 입력을 받을 수 있다.
 */

package bridge;

import bridge.exception.InvalidUserInputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        if(isBridgeInputNotDigit(bridgeSize)) {
            throw new InvalidUserInputException("[ERROR] 숫자로 입력해 주세요.");
        } else if(Integer.parseInt(bridgeSize) < 3 || 20 < Integer.parseInt(bridgeSize)) {
            throw new InvalidUserInputException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 다리의 길이가 숫자인지 검증한다.
     */
    public boolean isBridgeInputNotDigit(String size) {

        if(size.length() == size.chars().mapToObj(c -> (char)c)
                .filter(Character :: isDigit)
                .count()) {

            return false;
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String nextStep = Console.readLine();

        if(!isBridgeInputNotDigit(nextStep)) {
            throw new InvalidUserInputException("[ERROR] 문자를 입력해 주세요.");
        } else if(!nextStep.equals("U") && !nextStep.equals("D")) {
            throw new InvalidUserInputException("[ERROR] U, D 중 하나를 입력해 주세요.");
        }

        return nextStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();

        if(!isBridgeInputNotDigit(command)) {
            throw new InvalidUserInputException("[ERROR] 문자를 입력해 주세요.");
        } else if(!command.equals("R") && !command.equals("Q")) {
            throw new InvalidUserInputException("[ERROR] R, Q 중 하나를 입력해 주세요.");
        }

        return command;
    }
}

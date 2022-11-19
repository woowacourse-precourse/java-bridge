package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidationChecker validationChecker = new ValidationChecker();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validationChecker.checkInputIsInteger(bridgeSize);
        validationChecker.checkInputIsNaturalNumber(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String Moving = Console.readLine();
        validationChecker.checkInputIsSpecificString(Moving, List.of("U","D"));
        return Moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String Command = Console.readLine();
        validationChecker.checkInputIsSpecificString(Command, List.of("R","Q"));
        return Command;
    }
}

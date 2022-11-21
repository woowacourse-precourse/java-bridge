package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static ValidationChecker validationChecker = new ValidationChecker();
    static OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        try {
            validationChecker.checkInputIsInteger(bridgeSize);
            validationChecker.checkIntegerRange(Integer.parseInt(bridgeSize), 3, 20);
        }catch (NumberFormatException e){ outputView.printBridgeSizeIntegerError();
            return readBridgeSize();
        }catch (IllegalArgumentException e) { outputView.printBridgeSizeIntegerRangeError();
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String Moving = Console.readLine();
        try {
            validationChecker.checkInputIsSpecificString(Moving, List.of("U","D"));
        }catch (IllegalArgumentException e){ outputView.printMovingError();
            return readMoving();
        }
        return Moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String Command = Console.readLine();
        try {
            validationChecker.checkInputIsSpecificString(Command, List.of("R","Q"));
        }catch (IllegalArgumentException e){ outputView.printGameCommandError();
            return readGameCommand();
        }
        return Command;
    }
}

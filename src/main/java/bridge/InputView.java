package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ExceptionCase exceptionCase = new ExceptionCase();
    OutputView outputView = new OutputView();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printInputBridgeSize();
        int bridgeSize = exceptionCase.validateBridgeSizeIsInteger(Console.readLine());
        return exceptionCase.validateBridgeSizeInRange(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printInputMove();
        return exceptionCase.validateMoves(Console.readLine().toUpperCase());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printInputGameCommand();
        return exceptionCase.validateRetryCommand(Console.readLine().toUpperCase());
    }
}

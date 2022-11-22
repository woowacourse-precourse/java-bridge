package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.OutputView.printStartGame;
import static bridge.DownOrUp.*;
import static bridge.ErrorMessage.*;
import static bridge.BridgeGameMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static ValidityCheck validityCheck = new ValidityCheck();
    private final static String EXIT = "Q";
    private final static String RESTART = "R";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printStartGame();
        System.out.println(INPUT_BRIDGE_LENGTH.getValue());
        String inputBridgeLength = Console.readLine();
        if (!validityCheck.numberRangeChecker(inputBridgeLength) || !validityCheck.stringChecker(inputBridgeLength)) {
            throw new IllegalArgumentException(ER_BRIDGE_LENGTH_INPUT.getMessage());
        }
        return Integer.parseInt(inputBridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE.getValue());
        String inputUpOrDown = Console.readLine();
        if (!(inputUpOrDown.equals(UP.getName()) || inputUpOrDown.equals(DOWN.getName()))) {
            throw new IllegalArgumentException(ER_NOT_UP_OR_DOWN.getMessage());
        }
        return inputUpOrDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESTART_OF_END.getValue());
        String exitOrRestart = Console.readLine();
        if (!(exitOrRestart.equals(EXIT) || exitOrRestart.equals(RESTART))) {
            throw new IllegalArgumentException(ER_NOT_Q_OR_R.getMessage());
        }
        return exitOrRestart;
    }
}

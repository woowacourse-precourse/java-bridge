package bridge.views;

import bridge.ValidityCheck;
import camp.nextstep.edu.missionutils.Console;

import static bridge.enums.DorU.DOWN;
import static bridge.enums.DorU.UP;
import static bridge.enums.ErrorMessage.*;
import static bridge.enums.Sentence.*;
import static bridge.views.OutputView.printStartGame;

public class InputView {

    private static final ValidityCheck validityCheck = new ValidityCheck();
    private final static String EXIT = "Q";
    private final static String RESTART = "R";

    public int getBridgeLength() {
        printStartGame();
        System.out.println(INPUT_BRIDGE_LENGTH.getValue());
        String inputBridgeLength = Console.readLine();
        if (!validityCheck.numberRangeChecker(inputBridgeLength) || !validityCheck.stringChecker(inputBridgeLength)) {
            throw new IllegalArgumentException(ER_BRIDGE_LENGTH_INPUT.getMessage());
        }
        return Integer.parseInt(inputBridgeLength);
    }

    public String getMoveString() {
        System.out.println(MOVE.getValue());
        String inputDorU = Console.readLine();
        if (!(inputDorU.equals(UP.getName()) || inputDorU.equals(DOWN.getName()))) {
            throw new IllegalArgumentException(ER_NOT_D_OR_U.getMessage());
        }
        return inputDorU;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String getExitOrRestart() {
        System.out.println(RESTART_OF_END.getValue());
        String exitOrRestart = Console.readLine();
        if (!(exitOrRestart.equals(EXIT) || exitOrRestart.equals(RESTART))) {
            throw new IllegalArgumentException(ER_NOT_Q_OR_R.getMessage());
        }
        return exitOrRestart;
    }
}

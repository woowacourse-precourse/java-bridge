package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.enums.DorU.*;
import static bridge.enums.ErrorMessage.*;
import static bridge.enums.Sentence.*;
/*
 ** 제공된 InputView 클래스를 활용해 구현해야 한다.
 ** InputView의 패키지는 변경할 수 있다.
 ** InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 ** 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private static final ValidityCheck validityCheck = new ValidityCheck();
    private final static String EXIT = "Q";
    private final static String RESTART = "R";
    public static int getBridgeLength() {
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
    public static String getMoveString() {
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
    public static String getExitOrRestart() {
        System.out.println(RESTART_OF_END);
        String exitOrRestart = Console.readLine();
        if (!(exitOrRestart.equals(EXIT) || exitOrRestart.equals(RESTART))) {
            throw new IllegalArgumentException(ER_NOT_Q_OR_R.getMessage());
        }
        return exitOrRestart;
    }
}

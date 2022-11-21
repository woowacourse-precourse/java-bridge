package bridge;
import bridge.exception.ValidException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final ValidException validException;
    private static final String START_GAGE_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_NEXT_STEP = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    InputView(ValidException exception){
        this.validException = exception;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(START_GAGE_MESSAGE);
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        return validBridgeSize(Console.readLine());
    }

    private int validBridgeSize(String bridgeLengthOfString) {
        validException.validInteger(bridgeLengthOfString);
        validException.validIntegerRange(Integer.parseInt(bridgeLengthOfString));

        return Integer.parseInt(bridgeLengthOfString);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_NEXT_STEP);

        String nextStep = Console.readLine();
        validException.validMoveNextStep(nextStep);
        return nextStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_RESTART_OR_QUIT);
        String order = Console.readLine();
        validException.validOrder(order);
        return order;
    }
}

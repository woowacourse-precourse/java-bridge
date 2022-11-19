package bridge.view;

import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String RETRY = "R";
    private final String QUIT = "Q";

    private static final String BRIDGE_GAME_START_MSG = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String ERROR_MSG = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeLength = Console.readLine();
        try {
            int parseInt = parseIntOrThrowException(bridgeLength);
            validateBridgeSize(parseInt);
            return parseInt;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        try {
            return throwExceptionIfNotUpAndDown(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        try {
            return throwExceptionIfNotRetryAndQuit(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    public void getBridgeGameStartMsg(){
        System.out.println(BRIDGE_GAME_START_MSG);
    }

    public void getInputBridgeLengthMsg(){
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public void getInputMoveUpOrDownMsg() {
        System.out.println(INPUT_MOVE_UP_OR_DOWN);
    }

    public void getInputRestartOrQuitMsg() {
        System.out.println(INPUT_RESTART_OR_QUIT);
    }

    private int parseIntOrThrowException(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_MSG + "숫자가 아닌 값은 입력받을 수 없습니다.");
        }
    }

    private void validateBridgeSize(int size){
        if (size < 3 || size > 20){
            throw new IllegalArgumentException(ERROR_MSG + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private String throwExceptionIfNotUpAndDown(String input){
        if (!input.equals(Moving.UP.getDirection()) && !input.equals(Moving.DOWN.getDirection())){
            throw new IllegalArgumentException(ERROR_MSG + "U, D 이외의 문자는 입력할 수 없습니다.");
        }
        return input;
    }

    private String throwExceptionIfNotRetryAndQuit(String input){
        if (!input.equals(RETRY) && !input.equals(QUIT)){
            throw new IllegalArgumentException(ERROR_MSG + "R, Q 이외의 문자는 입력할 수 없습니다.");
        }
        return input;
    }
}

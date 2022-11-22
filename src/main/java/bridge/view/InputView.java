package bridge.view;

import bridge.domain.Command;
import bridge.exception.InputExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_LENGTH_OF_BRIDGE_MSG = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_TO_GO_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_SELECT_TO_RETRY_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_LENGTH_OF_BRIDGE_MSG);
        return InputExceptionHandler.bridgeSizeExceptionHandler(InputExceptionHandler.nullInputExceptionHandler());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Command readMoving() {
        System.out.println(INPUT_SELECT_TO_GO_MSG);
        return InputExceptionHandler.movingExceptionHandler(InputExceptionHandler.nullInputExceptionHandler());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        System.out.println(INPUT_SELECT_TO_RETRY_MSG);
        return InputExceptionHandler.gameCommandExceptionHandler(InputExceptionHandler.nullInputExceptionHandler());
    }
}

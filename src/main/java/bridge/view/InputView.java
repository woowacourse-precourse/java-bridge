package bridge.view;

import bridge.domain.MoveIndicator;
import bridge.domain.PlayIndicator;
import bridge.domain.Validator;

import static bridge.util.Notice.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends Validator {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(GAME_START.of());
            System.out.println(ENTER_BRIDGE_LENGTH.of());
            return validateNumericInput(readLine());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return readBridgeSize();
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(USER_MOVE.of());
            return validateCharacterInput(readLine(), MoveIndicator.all());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(GAME_RETRY.of());
            return validateCharacterInput(readLine(), PlayIndicator.all());
        }catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return readGameCommand();
        }
    }
}

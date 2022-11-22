package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

//사용자의 입력은 이 클래스를 사용해서만 받을 수 있다
//패키지 변경 가능
//메서드의 이름, 인자, 반환타입 변경 가능
//사용자 값 입력을 위해 필요한 메서드 추가 가능

public class InputView {

    ValidateInput validateInput = new ValidateInput();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        validateInput.validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String input) {
        validateInput.validateMoveAlphabet(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String input) {
        validateInput.validateGameCommand(input);
        return input;
    }
}

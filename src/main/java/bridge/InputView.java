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

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        if (!validateIsNumber(input) || !validateNumberInRange(input)) {
            throw new IllegalArgumentException(ExceptionHandler.BRIDGE_SIZE_EXCEPTION);
        }
    }

    private boolean validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) < '0' || input.charAt(i) > '9')
                return false;
        }
        return true;
    }

    private boolean validateNumberInRange(String input) {
        int inputNumber = Integer.parseInt(input);
        return inputNumber >= 3 && 20 >= inputNumber;
    }




    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String input) {
        if (!validateMoveAlphabet(input)) {
            throw new IllegalArgumentException(ExceptionHandler.MOVE_ALPHABET_EXCEPTION);
        }
        return input;
    }

    public boolean validateMoveAlphabet(String input) {
        return input.equals("U") || input.equals("D");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

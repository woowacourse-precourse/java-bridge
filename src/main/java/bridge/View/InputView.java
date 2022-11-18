
package bridge.View;

import camp.nextstep.edu.missionutils.*;
/*
* InputView 패키지는 변경할 수 있다.
* InputView 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
* 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
*/

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Messeges.INPUT_BRIDGE_LENGTH.msg);
        String bridgeSizeInput = readGameCommand();
        try {
            validateBridgeSize(bridgeSizeInput);
        }catch (IllegalArgumentException e) {
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }

    private void validateBridgeSize(String bridgeSizeInput) {
        String regex = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";
        if (!bridgeSizeInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

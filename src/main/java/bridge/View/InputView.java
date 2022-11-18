
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
        String bridgeSizeCommand = readGameCommand();
        try {
            validateBridgeSize(bridgeSizeCommand);
        }catch (IllegalArgumentException e) {
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSizeCommand);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Messeges.INPUT_SELECT_MOVING_POSITION.msg);
        String movingCommand = readGameCommand();
        try {
            validateMoving(movingCommand);
        }catch (IllegalArgumentException e) {
            readMoving();
        }
        return movingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return Console.readLine();
    }

    private void validateBridgeSize(String bridgeSizeCommand) {
        String regex = "^[3-9]$|^[1][0-9]$|^[2][0]$";
        if (!bridgeSizeCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoving(String movingCommand) {
        String regex = "[UD]";
        if (!movingCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

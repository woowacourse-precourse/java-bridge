package view.input;

import camp.nextstep.edu.missionutils.Console;
import bridge.clientValidation.ClientValidation;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 요구사항
 * 1. 제공된 InputView 클래스를 활용해 구현해야 한다.
 * 2. InputView 의 패키지는 변경할 수 있다.
 * 3. InputView 의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 4. 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private static final ClientValidation validation = new ClientValidation();

    public String repeat(InputMessage inputMessage) {
        while(true) {
            try {
                System.out.println("\n" + inputMessage.getMessage());
                return validation.validate(Console.readLine(), inputMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int readBridgeSize() {
        return Integer.parseInt(repeat(InputMessage.INPUT_BRIDGE_SIZE));
    }

    public String readMoving() {
        return repeat(InputMessage.INPUT_BRIDGE_MOVE);
    }

    public String readGameCommand() {
        return repeat(InputMessage.INPUT_RESTART_CODE);
    }
}
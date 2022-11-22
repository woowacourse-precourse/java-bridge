package bridge.view;

import bridge.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 시그니쳐와 반환타입 변경가능
 * 매서드 추가 가능
 * 패키지 변경 가능
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        Validator.isNumeric(input);

        int bridgeSize = Integer.parseInt(input);
        Validator.isInRange(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        Validator.isMoveCommand(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        Validator.isGameCommand(input);

        return input;
    }
}

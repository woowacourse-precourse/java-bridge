package bridge.view;

import bridge.util.validator.BridgeLengthValidator;
import bridge.util.validator.GameCommandValidator;
import bridge.util.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 및 메서드 시그니처와 리턴타입 변경 가능, 메서드 추가 가능
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        BridgeLengthValidator.validate(input);
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String SpaceToMove = Console.readLine();
        MovingValidator.validate(SpaceToMove);
        return SpaceToMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        GameCommandValidator.validate(gameCommand);
        return gameCommand;
    }
}

package bridge.view;

// 여기서만 사용자의 입력을 받을 수 있음
// 패키지 변경 가능
// 메서드의 시그니처(인자, 이름)와 반환 타입 변경 가능
// 사용자의 값 입력을 위해 필요한 메서드 추가 가능

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.PrintMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        new Validation().validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String moving = Console.readLine();
        new Validation().validateMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        new Validation().validateGameCommand(gameCommand);
        return gameCommand;
    }
}

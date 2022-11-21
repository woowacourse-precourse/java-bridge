package bridge.view;

import bridge.constant.InputMessage;
import bridge.verifier.InputVerifier;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputMessage.READ_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        InputVerifier.BridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.READ_MOVING);
        String moving = Console.readLine();
        InputVerifier.moving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.READ_GAME_COMMAND);
        String gameCommand = Console.readLine();
        InputVerifier.gameCommand(gameCommand);
        return gameCommand;
    }
}

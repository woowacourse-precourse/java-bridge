package bridge.view;

import bridge.exception.BridgeInputException;
import camp.nextstep.edu.missionutils.Console;
import bridge.message.ProgressMessage;

//사용자로부터 입력을 받는 역할을 한다.
public class InputView {

    private BridgeInputException bridgeInputException;

    public InputView() {
        this.bridgeInputException = new BridgeInputException();
    }


    // 게임을 시작하는 메시지
    public void initBridgeGame() {
        System.out.println(ProgressMessage.INIT_GAME_MESSAGE);
        System.out.println();
    }

    // 다리의 길이를 입력받는다.
    public int readBridgeSize() {
        System.out.println(ProgressMessage.BRIDGE_LENGTH_MESSAGE);
        String input = Console.readLine();
        bridgeInputException.validEmpty(input);
        bridgeInputException.validCharacter(input);
        bridgeInputException.validNumberRange(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    // 사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        System.out.println(ProgressMessage.BRIDGE_MOVE_MESSAGE);
        String input = Console.readLine();
        bridgeInputException.validMovingBridge(input);
        return input;
    }

    // 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readGameCommand() {
        System.out.println(ProgressMessage.RETRY_GAME_MESSAGE);
        String input = Console.readLine();
        bridgeInputException.validRetryBridge(input);
        return input;
    }
}

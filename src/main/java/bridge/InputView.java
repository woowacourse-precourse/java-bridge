package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.GameMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
        String bridgeInput = Console.readLine();
        Validator.validateBridgeInput(bridgeInput);
        return Integer.parseInt(bridgeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOICE_DIRECT_INPUT_MESSAGE);
        String moveInput = Console.readLine();
        Validator.validateMoveInput(moveInput);
        return moveInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(WHETHER_EXIT_AGAIN_GAME_MESSAGE);
        String restartInput = Console.readLine();
        Validator.validateRestartInput(restartInput);
        return restartInput;
    }
}

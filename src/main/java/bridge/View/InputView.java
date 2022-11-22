package bridge.View;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Constant.Constant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        validateRange(bridgeSize);
        return bridgeSize;
    }

    private void validateRange(String bridgeSize) {
        int bridgeLength = Integer.parseInt(bridgeSize);
        if(bridgeLength < 3 || bridgeLength > 20){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOOSE_MOVE);
        String moving = Console.readLine();
        validateUorD(moving);
        return moving;
    }

    private void validateUorD(String moving){
        if(!moving.equals("U") && !moving.equals("D")){
            throw new IllegalArgumentException(INPUT_MOVE_ERROR);
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_OR_QUIT);
        String command = Console.readLine();
        validateRestart(command);
        return command;
    }
    private void validateRestart(String command){
        if(!command.equals("R") && !command.equals("Q")){
            throw new IllegalArgumentException(INPUT_RESTART_ERROR);
        }
    }
}

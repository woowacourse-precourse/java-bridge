package bridge.View;

import camp.nextstep.edu.missionutils.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MSG.INPUT_BRIDGE_SIZE.message);
        String bridgeSizeCommand = Console.readLine();
        try {
            validateBridgeSize(bridgeSizeCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSizeCommand);
    }
    private void validateBridgeSize(String bridgeSizeCommand) {
        String regex = "^[3-9]$|^[1][0-9]$|^20$";
        if (!bridgeSizeCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MSG.INPUT_MOVING.message);
        String movingCommand = Console.readLine();
        try {
            validateMoving(movingCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readMoving();
        }
        return movingCommand;
    }
    private void validateMoving(String movingCommand) {
        String regex = "[UD]";
        if (!movingCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MSG.INPUT_GAME.message);
        String gameCommand = Console.readLine();
        try {
            validateGame(gameCommand);
        }catch (IllegalArgumentException e) {
            //에러메시지 출력부
            readGameCommand();
        }
        return gameCommand;
    }
    private void validateGame(String gameCommand) {
        String regex = "[RQ]";
        if (!gameCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

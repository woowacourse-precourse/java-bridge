package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        validMoveInput(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        validGameCommand(command);
        return command;
    }
    private int strToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Messages.IS_NOT_NUMBER.getMessage());
        }
    }
    private void isBetweenRange(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_INPUT_BRIDGE_MESSAGE.getMessage());
        }
    }
    private void validInput(String input){
        int size = strToInt(input);
        isBetweenRange(size);
    }

    private void validMoveInput(String input){
        if(!input.equals("D") && !input.equals("U")){
            throw new IllegalArgumentException(Messages.ERROR_INPUT_MOVE_MESSAGE.getMessage());
        }
    }

    private void validGameCommand(String input){
        if(!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException(Messages.ERROR_RETRY_MESSAGE.getMessage());
        }
    }
}

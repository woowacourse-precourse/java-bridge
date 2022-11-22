package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private ValidateUserInput validateUserInput;
    /**
     * 다리의 길이를 입력받는다.
     */
    public InputView(){
        validateUserInput = new ValidateUserInput();
    }
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateUserInput.checkBridgeLength(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingCommand = Console.readLine();
        validateUserInput.checkReadMoving(movingCommand);
        return movingCommand;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(){
        String restartCommand = Console.readLine();
        validateUserInput.checkGameCommand(restartCommand);
        return restartCommand;
    }
    public int getBrideSize() {
        try {
            return readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.SIZE_ERROR.getError());
            return getBrideSize();
        }
    }
    public String getReadMoving() {
        try {
            return readMoving();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.MOVE_ERROR.getError());
            return getReadMoving();
        }
    }
    public String getReadCommand(){
        try {
           return readGameCommand();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.RESTART_ERROR.getError());
            return getReadCommand();
        }
    }
}

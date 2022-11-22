package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String input(){
        return Console.readLine();
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = input();
        try{
            Exception.checkInputIsNum(bridgeSize);
            Exception.checkBridgeSizeRange(Integer.valueOf(bridgeSize));
        }catch(IllegalArgumentException e){
            return readBridgeSize();
        }
        return Integer.valueOf(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = input();
        try{
            Exception.checkMovingString(moving);
        }catch(IllegalArgumentException e){
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = input();
        try{
            Exception.checkGameCommandString(gameCommand);
        }catch(IllegalArgumentException e){
            return readGameCommand();
        }
        return gameCommand;
    }
}

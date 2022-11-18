package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidateUserInput validateUserInput = new ValidateUserInput();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = getBrideSize();
        return Integer.parseInt(bridgeSize);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return getReadMoving();
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(){
        return getReadCommand();
    }
    public String getBrideSize(){
        String bridgeSize;
        while(true){
        try {
                bridgeSize = Console.readLine();
                validateUserInput.checkBridgeLength(bridgeSize);
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] 다리 길이는 3 ~ 20 사이의 숫자여야 합니다.");
                continue;
            }
            break;
        }
        return bridgeSize;
    }
    public String getReadMoving(){
        String movingCommand;
        while(true){
            try {
                movingCommand = Console.readLine();
                validateUserInput.checkReadMoving(movingCommand);
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] U, D 커멘드만 입력해주세요.");
                continue;
            }
            break;
        }
        return movingCommand;
    }
    public String getReadCommand(){
        String restartCommand;
        while(true){
            try {
                restartCommand = Console.readLine();
                validateUserInput.checkGameCommand(restartCommand);
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] R, Q 커멘드만 입력해주세요.");
                continue;
            }
            break;
        }
        return restartCommand;
    }
}

package bridge;

// 여기에서만 readLine()을 사용할 것.

import camp.nextstep.edu.missionutils.Console;
import data.ExceptionData;
import data.BridgeData;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String rawData;
        while(true){
            System.out.println("입력");
            try{
                rawData = readLine();
                return validateSize(rawData);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_SIZE.printExceptionData();
            }
        }
    }

    /**
     * 다리 길이 예외 검사
     * @param rawData 아직 문자열 상태인 데이터
     * @throws IllegalArgumentException 3보다 작거나 20보다 크면 예외 발생
     */
    private int validateSize(String rawData) throws IllegalArgumentException {
        try{
            int rawSize = Integer.parseInt(rawData);
            if(rawSize < 3 || rawSize > 20){
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = readLine();
        validateMove(moving);
        return moving;
    }

    private void validateMove(String moving){
        try {
            if (!moving.equals(BridgeData.UP) || !moving.equals(BridgeData.DOWN)) {
                throw new IllegalArgumentException(ExceptionData.EXCEPTION_MOVE.name());
            }
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionData.EXCEPTION_MOVE.name());
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = readLine();
        validateCommand(gameCommand);
        return gameCommand;
    }

    private void validateCommand(String command) throws IllegalArgumentException{
        try {
            if (!command.equals(BridgeData.RESTART) || !command.equals(BridgeData.QUIT)) {
                throw new IllegalArgumentException(ExceptionData.EXCEPTION_RESTART.name());
            }
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionData.EXCEPTION_RESTART.name());
        }
    }
    public String readLine() {
        String liner = Console.readLine();
        return liner;
    }
}

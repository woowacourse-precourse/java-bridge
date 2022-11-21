package View;

// 여기에서만 readLine()을 사용할 것.

import camp.nextstep.edu.missionutils.Console;
import data.ExceptionData;
import data.BridgeData;
import data.InputGuide;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

/*
리팩토링 예정 1
validate 메서드 한꺼번에 수행하도록 합칠 것.
상수로 직접 접근하지 않고 데이터셋으로 받아서 포함 안되는지 체크하도록 하자.
 */
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
            try{
                InputGuide.SIZE.printGuideWithLine();
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
            return rawSize;
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            try {
                InputGuide.MOVE.printGuideWithLine();
                String moving = readLine();
                validateMove(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println("U or D");
            }
        }
    }

    private void validateMove(String moving){
        try {
            if (!moving.equals(BridgeData.UP) && !moving.equals(BridgeData.DOWN)) {
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

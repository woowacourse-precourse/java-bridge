package bridge;

// 여기에서만 readLine()을 사용할 것.

import camp.nextstep.edu.missionutils.Console;
import data.ExceptionData;
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
                rawData = Console.readLine();
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

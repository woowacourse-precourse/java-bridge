package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator = new Validator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputBridgeSize = Console.readLine();
        try{
            if (validator.bridgeSizeValidator(inputBridgeSize)) {
                return Integer.parseInt(inputBridgeSize);
            }
        }catch (Exception e){
            throw new NoSuchElementException(e.getMessage());
        }
        throw new NoSuchElementException("[ERROR] 다리 길이 입력에서 오류가 발생했습니다.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputMoving = Console.readLine();
        if(validator.readMovingValidator(inputMoving)){
            return inputMoving;
        }
        throw new IllegalArgumentException("[ERROR] U 혹은 D를 입력해주세요.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputRetry = Console.readLine();
        if(validator.readRetryValidator(inputRetry)){
            return inputRetry;
        }
        throw new IllegalArgumentException("[ERROR] R 혹은 Q를 입력해주세요.");
    }
}

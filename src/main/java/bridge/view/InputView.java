package bridge.view;

import bridge.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String sizeInput = Console.readLine();
        if(Integer.parseInt(sizeInput)<3 || Integer.parseInt(sizeInput)>20){
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_RANGE.getMessage());
        }
        return sizeInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String movingInput = Console.readLine();
        if(!movingInput.equals("U")&&!movingInput.equals("D")){
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_CROSS_INPUT.getMessage());
        }
        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry = Console.readLine();
        if(!retry.equals("R")&&!retry.equals("Q")){
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT.getMessage());
        }
        return retry;
    }
}

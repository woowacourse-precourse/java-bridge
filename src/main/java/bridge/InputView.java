package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = -1;
        try {
            String input = Console.readLine();
            bridgeSize = Util.stringToInteger(input);
        } catch (IllegalArgumentException iae) {
            String errorMessage = iae.getMessage();
            System.out.println(errorMessage);
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = "";
        try {
            input = Console.readLine();
            ExceptionBasket.invalidGameKey(input);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            input = "";
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = "";
        try{
            input = Console.readLine();
            ExceptionBasket.invalidRetryRequestInputKey(input);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            input = "";
        }
        return input;
    }


}

package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readline(){
        String input = Console.readLine();
        return (input);
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException("3 이상 20 이하의 숫자여야 합니다.");
        }
        return (bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String input) {
        if (!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException();
        }
        return (input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException();
        }
        return (input);
    }
}

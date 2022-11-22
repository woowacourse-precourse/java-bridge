package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        int bridgeSize = 0;
        String errorMsg = "[ERROR] 잘못된 다리 길이 입력, 다시 입력하세요";
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        }catch (Exception e){
            throw new IllegalArgumentException(errorMsg);
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(errorMsg);
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        String answer = Console.readLine();
        if(answer.equals("U") || answer.equals("D"))
            return answer;
        throw new IllegalArgumentException("[ERROR] 잘못된 이동할 칸 입력, 다시 입력하세요");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

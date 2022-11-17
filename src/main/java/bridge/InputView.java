package bridge;

import bridge.model.Error;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        String userInput = Console.readLine().trim();
        isNumber(userInput);
        int bridgeSize = Integer.parseInt(userInput);
        numberRangeCheck(bridgeSize);
        return bridgeSize;
    }

    private void numberRangeCheck(int bridgeSize) throws IllegalArgumentException {
        if(bridgeSize < 3 || bridgeSize >20){
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

    private void isNumber(String words) throws IllegalArgumentException {
        for (int i = 0; i < words.length(); i++) {
            int ascii = (int)words.charAt(i);
            if (ascii < 48 || ascii > 57) {
                throw new IllegalArgumentException(Error.NOT_A_NUMBER.getMessage());
            }
        }
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

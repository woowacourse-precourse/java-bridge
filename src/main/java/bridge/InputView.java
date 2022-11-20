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
        String bridgeSize=Console.readLine();
        checkDigit(bridgeSize);
        int size=Integer.parseInt(bridgeSize);
        checkRange(size);
        return size;
    }

    public void checkDigit(String bridgeSize) {
        final String REGEX="[0-9]+";
        if(!bridgeSize.matches(REGEX)){
            throw new IllegalArgumentException("[ERROR] 다리 길이에 숫자만 입력하세요.");
        }
    }

    public void checkRange(int size){
        if(!(3<=size&&size<=20)){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving=Console.readLine();
        checkMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

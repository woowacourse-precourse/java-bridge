package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String bridgeSizeStr =  Console.readLine();
        if (isBlank(bridgeSizeStr) ){
            throw new IllegalArgumentException(" 다리 길이는 숫자여야합니다.");
        }
        return checkBridgeSizeRange(toInts(bridgeSizeStr));
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

    public int toInts(String bridgeSize) {
        try{
            return Integer.parseInt(bridgeSize);
        }catch(IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException(" 다리 길이는 숫자여야합니다");
        }
    }
    public boolean isBlank(String text){
        return text == null || text.trim().isEmpty();
    }
    public int checkBridgeSizeRange(int bridgeSize) throws IllegalArgumentException {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(" 다리 길이는 3에서 20사이여야합니다.");
        }
        return bridgeSize;
    }
}

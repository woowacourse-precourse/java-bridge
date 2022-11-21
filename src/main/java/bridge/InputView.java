package bridge;

import camp.nextstep.edu.missionutils.Console;



/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ERROR_MESSAGE = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            String bridgeSizeStr = Console.readLine();
            return checkBridgeSizeRange(toInts(isBlank(bridgeSizeStr)));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        try {
            String moving = Console.readLine();
            return checkMovingEnum(isBlank(moving));
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            return readMoving();
        }
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
            throw new IllegalArgumentException(" 다리 길이는 숫자여야합니다. 3~20 사이의 숫자만 입력해주세요");
        }
    }
    public String isBlank(String text){
        if (text == null || text.trim().isEmpty()){
            throw new IllegalArgumentException(" 입력에 공백을 입력했습니다.");
        }
        return text;
    }
    public int checkBridgeSizeRange(int bridgeSize) throws IllegalArgumentException {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(" 다리 길이는 3에서 20사이여야합니다.");
        }
        return bridgeSize;
    }
    public String checkMovingEnum(String moving) throws IllegalArgumentException {
        if(moving.equals("U") || moving.equals("D")){
            return moving;
        }
        throw new IllegalArgumentException(" 이동할 칸은 U 혹은 D 만 입력해야만합니다.");
        // "U" -> 변수선언 가능성
        // enum class 이용 가능
    }
}

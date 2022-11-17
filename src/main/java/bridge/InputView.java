package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        try{
            int bridgeLength = Integer.parseInt(input);
            return bridgeLength;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.");
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

    private int validateNotNumber(String input){
        try{
            int len = Integer.parseInt(input);
            return len;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다.");
        }
    }

    private void validateNumberRange(int len){
        if(len < 3 || len > 20){
            throw new IllegalArgumentException("[ERROR] 숫자는 3~20 범위로 입력해야 합니다.");
        }
    }

}

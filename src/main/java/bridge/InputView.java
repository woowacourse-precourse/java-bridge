package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR="[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String Input=Console.readLine();
        checkError(Input);
        return Integer.parseInt(Input);
    }
    public void checkError(String Input){
        isNumber(Input);
        int size=Integer.parseInt(Input);
        isRange(size);
    }
    public void isNumber(String Input){
        try{
            Double.parseDouble(Input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR);
        }
    }

    public void isRange(int Size){
        if(!(Size>=3&&Size<=20)){
            throw new IllegalArgumentException(ERROR);
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

package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR="[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_UD="[ERROR] 이동할 칸의 입력은 U,D 둘중 하나만 입력해야합니다.";
    private static final String ERROR_RQ="[ERROR] 게임의 재시작 여부 입력은 R,Q 둘중 하나만 입력해야합니다.";
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
        String Input=Console.readLine();
        isUD(Input);
        return Input;
    }
    public void isUD(String Input){
        if(!(Input.equals("U")||Input.equals("D"))){
            throw new IllegalArgumentException(ERROR_UD);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String regame=Console.readLine();
        isRQ(regame);
        return regame;
    }
    public void isRQ(String Input){
        if(!(Input.equals("R")||Input.equals("Q"))){
            throw new IllegalArgumentException(ERROR_RQ);
        }
    }
}

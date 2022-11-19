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
        int result = validateNumber(Console.readLine());
        validateSize(result);
        return result;
    }
    private int validateNumber(String input){
        for (int i = 0; i < input.length(); i++)
        {
            if ((input.charAt(i) > '9' && input.charAt(i) < '0'))
                throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
    private void validateSize(int size){
        if(size<3 || size>20){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movePointer = Console.readLine();
        validateMove(movePointer);
        return movePointer;
    }
    private void validateMove(String movePointer){
        if(!movePointer.equals("U") && !movePointer.equals("D")){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}

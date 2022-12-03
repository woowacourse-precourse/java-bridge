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
        int result = validateNumber(Console.readLine());
        validateSize(result);
        return result;
    }
    private int validateNumber(String input) throws IllegalArgumentException{
        for (int i = 0; i < input.length(); i++)
        {
            if ((input.charAt(i) > '9' || input.charAt(i) < '0'))
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자로만 입력하여야 합니다.");
        }
        return Integer.parseInt(input);
    }
    private void validateSize(int size) throws IllegalArgumentException{
        if(size<3 || size>20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하로만 입력하여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        String movePointer = Console.readLine();
        validateMove(movePointer);
        return movePointer;
    }
    private void validateMove(String movePointer) throws IllegalArgumentException{
        if(!movePointer.equals("U") && !movePointer.equals("D")){
            throw new IllegalArgumentException("[ERROR] 방향은 U 와 D만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() throws IllegalArgumentException{
        String command = Console.readLine();
        validateCommand(command);
        if(command.equals("Q")){
            return false;
        }
        return true;
    }

    private void validateCommand(String command)throws IllegalArgumentException{
        if (!((command.charAt(0) == 'R' || command.charAt(0) == 'Q') && command.length()==1))
            throw new IllegalArgumentException("[ERROR] 재시도 R , 종료 Q 만 입력 가능합니다.");
    }
}

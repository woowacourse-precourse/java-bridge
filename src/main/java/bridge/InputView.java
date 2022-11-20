package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws InputMismatchException {
        String input = Console.readLine();

        return validateBridgeSize(input);
    }

    public int validateBridgeSize(String input) throws InputMismatchException {
        try{
            int size = Integer.parseInt(input);
            if(size < 3 || size > 20)
                throw new Exception();

            return size;
        }
        catch(Exception e){
            throw new InputMismatchException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException{
        String input = Console.readLine();

        validateMoving(input);

        return input;
    }

    public void validateMoving(String input) throws IllegalArgumentException{
        BridgeCondition.findByDataValue(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();

        validateCommand(input);

        return input;
    }

    public void validateCommand(String input) throws  IllegalArgumentException{
        if(!(input.equals("R") || input.equals("Q"))){
            throw new IllegalArgumentException("[ERROR] 재시도는 R, 종료는 Q를 입력해주세요.");
        }
    }
}

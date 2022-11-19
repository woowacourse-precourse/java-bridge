package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static Constant.BridgeConstant.MIN_SIZE;
import static Constant.BridgeConstant.MAX_SIZE;
import static Constant.BridgeInput.MOVE_CHOICE;
import static Constant.BridgeInput.GAME_RESTART;
import static Constant.PrintText.*;
import static Constant.ErrorMessage.*;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;
        int size;
        while(!isDigit(input=Console.readLine())){}
        size = convertToInteger(input);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        while(!isValidChoice(input=Console.readLine() , MOVE_CHOICE.getValue()));
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private boolean isValidChoice(String input, List<String> choicePool){
        try {
            if (choicePool.contains(input)) {
                return true;
            }
            throw new IllegalArgumentException(INVALID_MOVE.getErrorMsg());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private boolean isDigit(String input){
        try{
            if(!input.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(INVALID_DIGIT.getErrorMsg());
            }
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private Integer convertToInteger(String input){
        return Integer.parseInt(input);
    }
    private void testVaildRange(){

    }
}

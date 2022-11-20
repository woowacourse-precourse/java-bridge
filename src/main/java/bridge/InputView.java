package bridge;

import Constant.BridgeInput;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static Constant.BridgeConstant.*;

import static Constant.BridgeInput.GAME_RESTART;
import static Constant.BridgeInput.MOVE_CHOICE;
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
        int size = -1;
        do{
            System.out.println(BRIDGE_SIZE_INPUT.getText());
            input=Console.readLine();
            if(!isDigit(input)){
                continue;
            }
            size = Integer.parseInt(input);
        }while(!isValidRange(size));

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        do{
            System.out.println(BRIDGE_MOVE_INPUT.getText());
            input = Console.readLine();
        }
        while(!isValidChoice(input, MOVE_CHOICE));
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;
        do{
            System.out.println(RESTART_INPUT.getText());
            input = Console.readLine();
        }while(!isValidChoice(input , GAME_RESTART));
        return input;
    }
    public boolean isRestart(){
        String input = readGameCommand();
        return Constant.MoveCondition.valueOf(input).getCond();
    }

    private boolean isValidChoice(String input, BridgeInput enumChoice){
        try {
            List<String> choicePool = enumChoice.getValue();
            if (choicePool.contains(input)) {
                return true;
            }
            throw new IllegalArgumentException(enumChoice.getErrorMsg());
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
    private boolean isValidRange(int input){
        try{
            if(input>= INPUT_RANGE.getMin() && input<= INPUT_RANGE.getMax()){
                return true;
            }
            throw new IllegalArgumentException(INPUT_RANGE.getErrorMsg());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}

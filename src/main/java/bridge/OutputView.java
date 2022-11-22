package bridge;

import bridge.Field;

import java.util.ArrayList;

import static bridge.enums.BridgeMsgs.*;
import static bridge.enums.BridgeConstants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(ArrayList<Field> userBridge) {
        boolean first = printRow(userBridge, UPSIDE.getValue());
        boolean second = printRow(userBridge, DOWNSIDE.getValue());
        if(first && second){
            return true;
        }
        return false;
    }

    public boolean printRow(ArrayList<Field> userBridge, String position) {
        System.out.print(BRACKET_OPEN.getValue());
        for(int i=0; i< userBridge.size(); i++){
            printCorrectOrNot(userBridge.get(i), position);
            if(i != userBridge.size() -1){
                System.out.print(DIVIDE.getValue());
            }
        }
        System.out.println(BRACKET_CLOSE.getValue());
        return returnCorrectOrNot(userBridge.get(userBridge.size()-1), position);
    }

    private void printCorrectOrNot(Field field, String position){
        if(field.getLocation().equals(position) && field.isCorrection()){
            System.out.print(CORRECT.getValue());
            return;
        }
        if(field.getLocation().equals(position) && !field.isCorrection()){
            System.out.print(INCORRECT.getValue());
            return;
        }
        System.out.print(BLANK.getValue());
    }

    public boolean returnCorrectOrNot(Field field, String position){
        if(field.getLocation().equals(position) && !field.isCorrection()){
            return false;
        }
        return true;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ArrayList<Field> userBridge, int gameTryNumber, String gameSuccess) {
        System.out.println(FINAL_RESULT_MSG.getValue());
        printMap(userBridge);
        System.out.println(FINAL_GAME_SUCCESS_MSG.getValue() + gameSuccess);
        System.out.println(FINAL_GAME_TRY_MSG.getValue() + gameTryNumber);
    }
}

package bridge.View;

import bridge.Domain.BridgeRow;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    static final String BRIDGE_START = "[";
    static final String BRIDGE_END = "]";
    static final String BLANK = " ";
    static final String BAR = "|";
    static final String CORRECT_SPACE = "O";
    static final String WRONG_SPACE = "X";
    static final String SUCCESS_MESSAGE = "성공";
    static final String FAILURE_MESSAGE = "실패";
    static final String PRINT_SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    static final String PRINT_GAME_TRY_COUNT = "총 시도한 횟수: ";


    public void printMap(List<String> bridge, boolean success, int position) { //depth줄이기, 함수길이 줄이기
        List<String> check = new ArrayList<>();
        check.add("U"); //enum
        check.add("D"); //enum
        for(int index = 0; index< BridgeRow.getBridgeRowNumber(); index++){
            String standard = check.get(index);
            printMapStartPoint(bridge, standard, position);
            printMapEndPoint(bridge.get(position), standard, success);
        }
        System.out.println();
    }
    public void printMapStartPoint(List<String> bridge, String standard, int position){
        System.out.print(BRIDGE_START);
        for(int index=0; index<position; index++){
            String eachSpace = BLANK;
            if(standard.equals(bridge.get(index))){
                eachSpace = CORRECT_SPACE;
            }
            System.out.print(BLANK + eachSpace + BLANK);
            System.out.print(BAR);
        }
    }

    public void printMapEndPoint(String bridgePosition, String standard, boolean success){
        String eachSpace = checkLastPrint(bridgePosition, standard, success);
        System.out.print(BLANK + eachSpace + BLANK);
        System.out.println(BRIDGE_END);
    }

    public String checkLastPrint(String bridgePosition, String standard, boolean success){
        if(success){
            if(standard.equals(bridgePosition))
                return CORRECT_SPACE;
        }
        if(standard.equals(bridgePosition))
            return WRONG_SPACE;
        return BLANK;
    }

    public void printResult(boolean gameSuccess, int gameTryCount) {
        String success = FAILURE_MESSAGE;
        if(gameSuccess)
            success = SUCCESS_MESSAGE;
        System.out.println(PRINT_SUCCESS_OR_FAILURE_MESSAGE + success);
        System.out.println(PRINT_GAME_TRY_COUNT + gameTryCount);
    }
}

package bridge.View;

import bridge.Domain.BridgeRow;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String BLANK = " ";
    private static final String BAR = "|";
    private static final String CORRECT_SPACE = "O";
    private static final String WRONG_SPACE = "X";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAILURE_MESSAGE = "실패";
    private static final String PRINT_SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    private static final String PRINT_GAME_TRY_COUNT = "총 시도한 횟수: ";
    private static final String GAME_END_MESSAGE = "최종 게임 결과";

    public void printGameEndMessage(){
        System.out.println(GAME_END_MESSAGE);
    }

    public void printMap(List<String> myMovingChoices, boolean movingSuccess, int presentPosition) {
        for(int index = BridgeRow.getBridgeRowSize() - 1; index >= 0 ; index--){
            String correctBridgeChoice = BridgeRow.getRowNameUsingRowNumber(index);
            printMapStartPoint(myMovingChoices, correctBridgeChoice, presentPosition);
            printMapEndPoint(myMovingChoices.get(presentPosition), correctBridgeChoice, movingSuccess);
        }
        System.out.println();
    }
    public void printMapStartPoint(List<String> myMovingChoices, String correctBridgeChoice, int presentPosition){
        System.out.print(BRIDGE_START);
        for(int index = 0; index < presentPosition; index++){
            String eachSpace = BLANK;
            if(correctBridgeChoice.equals(myMovingChoices.get(index)))
                eachSpace = CORRECT_SPACE;
            System.out.print(BLANK + eachSpace + BLANK);
            System.out.print(BAR);
        }
    }

    public void printMapEndPoint(String myBridgeChoice, String correctBridgeChoice, boolean movingSuccess){
        String eachSpace = checkLastPrint(myBridgeChoice, correctBridgeChoice, movingSuccess);
        System.out.print(BLANK + eachSpace + BLANK);
        System.out.println(BRIDGE_END);
    }

    public String checkLastPrint(String myBridgeChoice, String correctBridgeChoice, boolean movingSuccess){
        if(movingSuccess){
            if(correctBridgeChoice.equals(myBridgeChoice))
                return CORRECT_SPACE;
        }
        if(correctBridgeChoice.equals(myBridgeChoice))
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

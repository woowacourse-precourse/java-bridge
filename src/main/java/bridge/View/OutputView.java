package bridge.View;

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
        check.add("U");
        check.add("D");

        for(int i=0; i<2; i++){
            String standard = check.get(i);
            System.out.print(BRIDGE_START);
            for(int j=0; j<position; j++){
                String eachSpace = BLANK;
                if(standard.equals(bridge.get(j))){
                    eachSpace = CORRECT_SPACE;
                }
                System.out.print(BLANK + eachSpace + BLANK);
                System.out.print(BAR);
            }
            if(success){
                String eachSpace = BLANK;
                if(standard.equals(bridge.get(position))){
                    eachSpace = CORRECT_SPACE;
                }
                System.out.print(BLANK + eachSpace + BLANK);
            }
            else{
                String eachSpace = BLANK;
                if(standard.equals(bridge.get(position))){
                    eachSpace = WRONG_SPACE;
                }
                System.out.print(BLANK + eachSpace + BLANK);
            }
            System.out.println(BRIDGE_END);
        }
        System.out.println();
    }

    public void printResult(boolean gameSuccess, int gameTryCount) {
        String success = FAILURE_MESSAGE;
        if(gameSuccess)
            success = SUCCESS_MESSAGE;
        System.out.println(PRINT_SUCCESS_OR_FAILURE_MESSAGE + success);
        System.out.println(PRINT_GAME_TRY_COUNT + gameTryCount);
    }
}

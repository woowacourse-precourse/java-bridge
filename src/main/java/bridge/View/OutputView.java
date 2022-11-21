package bridge.View;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    static final String BRIDGE_START = "[";
    static final String BRIDGE_END = "[";


    public void printMap(List<String> bridge, boolean success, int position) {
        List<String> check = new ArrayList<>();
        check.add("U");
        check.add("D");

        for(int i=0; i<2; i++){
            String standard = check.get(i);
            System.out.print(BRIDGE_START);
            for(int j=0; j<position; j++){
                String eachSpace = " ";
                if(standard.equals(bridge.get(j))){
                    eachSpace = "O";
                }
                System.out.print(" " + eachSpace + " ");
                System.out.print("|");
            }
            if(success){
                String eachSpace = " ";
                if(standard.equals(bridge.get(position))){
                    eachSpace = "O";
                }
                System.out.print(" " + eachSpace + " ");
            }
            else{
                String eachSpace = " ";
                if(standard.equals(bridge.get(position))){
                    eachSpace = "X";
                }
                System.out.print(" " + eachSpace + " ");
            }
            System.out.println(BRIDGE_END);
        }
        System.out.println();
    }

    public void printResult(boolean gameSuccess, int gameTryCount) {
        String success = "실패";
        if(gameSuccess)
            success = "성공";
        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }
}

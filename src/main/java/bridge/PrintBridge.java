package bridge;

import java.util.List;

public class PrintBridge {
    public void printBridgeMoveResult(List<String> answer, int index){
        printStair("U", index, answer.size(), answer);
        printStair("D", index, answer.size(), answer);
    }
    private void printStair(String move, int index, int length, List<String> answer){
        System.out.print("[");
        int i = 0;
        for(; i < index ; i++){
            checkBlock(answer.get(i), move);
            if(index != length-1)
                System.out.print("|");
        }
        if(index >= length || answer.get(index) != move) {
            System.out.print(" X ");
            i++;
        }
        for(; i < length ; i++){
            System.out.print("   ");
            if(index != length-1)
                System.out.print("|");
        }
        System.out.println("]");
    }

    private void checkNowPosition(String now ){

    }

    private void checkBlock(String answer, String move){
        if(answer == move) {
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }
}

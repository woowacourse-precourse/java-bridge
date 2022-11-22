package bridge;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> resultBridge) {
        recentMovingUpOutput(resultBridge);
        System.out.println();
        recentMovingDownOutput(resultBridge);
        System.out.println();
        System.out.println();
    }

    public void recentMovingUpOutput(List<String> resultBridge){
        System.out.print("[");
        for(int i = 0 ; i < resultBridge.size() ; i++){
            recentupOXoutput(resultBridge.get(i));
            if(i == resultBridge.size()-1){
                break;
            }
            System.out.print("|");
        }
        System.out.print("]");
    }
    public void recentMovingDownOutput(List<String> resultBridge){
        System.out.print("[");
        for(int i = 0 ; i < resultBridge.size() ; i++){
            recentdownOXoutput(resultBridge.get(i));
            if(i == resultBridge.size()-1){
                break;
            }
            System.out.print("|");
        }
        System.out.print("]");
    }
    public void recentupOXoutput(String str){
        if(str.equals("O_up")){
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }
    public void recentdownOXoutput(String str){
        if(str.equals("O_down")){
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> resultBridge) {
        movingUpOutput(resultBridge);
        System.out.println();
        movingDownOutput(resultBridge);
        System.out.println();
        System.out.println();
    }
    public void movingUpOutput(List<String> resultBridge){
        System.out.print("[");
        for(int i = 0 ; i < resultBridge.size() ; i++){
            upOXoutput(resultBridge.get(i));
            if(i == resultBridge.size()-1){
                break;
            }
            System.out.print("|");
        }
        System.out.print("]");
    }
    public void movingDownOutput(List<String> resultBridge){
        System.out.print("[");
        for(int i = 0 ; i < resultBridge.size() ; i++){
            downOXoutput(resultBridge.get(i));
            if(i == resultBridge.size()-1){
                break;
            }
            System.out.print("|");
        }
        System.out.print("]");
    }
    public void upOXoutput(String str){
        if(str.equals("X_up")){
            System.out.print(" X ");
            return;
        }
        if(str.equals("O_up")){
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }
    public void downOXoutput(String str){
        if(str.equals("X_down")){
            System.out.print(" X ");
            return;
        }
        if(str.equals("O_down")){
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }

    public void rightResultGame(List<String> resultBridge, int retry){
        gameResultOutput(resultBridge, "성공", retry);
    }
    public void wrongResultGame(List<String> resultBridge, int retry){
        System.out.println("최종 게임 결과");
        gameResultOutput(resultBridge, "실패", retry);
    }
    public void gameResultOutput(List<String> resultBridge, String result, int retry){
        printResult(resultBridge);
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + retry);
    }

}

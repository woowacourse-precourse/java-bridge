package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void startGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int userPosition, String userDecision, boolean checkDirection, List<String> bridge) {
        printUpperBridge(userPosition, userDecision, checkDirection, bridge);
        printLowerBridge(userPosition, userDecision, checkDirection, bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printUpperBridge(int userPosition, String userDecision, boolean checkDirection, List<String> bridge){

    }

    public void printLowerBridge(int userPosition, String userDecision, boolean checkDirection, List<String> bridge){

    }

    public void printWhetherUserDecisionIsCorrect(String userDecision, boolean checkDirection){
        if(userDecision.equals("U")){
            printWhetherCheckDirectionIsCorrect(checkDirection);
            return;
        }
        System.out.print("   ");
    }

    public void printWhetherCheckDirectionIsCorrect(boolean checkDirection){
        if(checkDirection == true){
            System.out.print(" O ");
            return;
        }
        System.out.print(" X ");
    }

    public void printOnePartOfUpperBridge(int index, List<String> bridge){
        if(bridge.get(index).equals("U")){
            System.out.print(" O ");
            return;
        }

        System.out.print("   ");
    }

    public void printOnePartOfLowerBridge(int index, List<String> bridge){
        if(bridge.get(index).equals("D")){
            System.out.print(" O ");
            return;
        }

        System.out.print("   ");
    }

    public void printMapStart(){
        System.out.print("[");
    }

    public void printSeparation(){
        System.out.print("|");
    }

    public void printMapEnd(){
        System.out.println("]");
    }

}

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
    public void printMap(int userPosition, String moving, List<String> bridge) {
        printUpperBridge(userPosition, moving, bridge);
        printLowerBridge(userPosition, moving, bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printUpperBridge(int userPosition, String moving, List<String> bridge){
        printMapStart();
        for(int i = 0; i < userPosition; i++){
            printOnePartOfUpperBridge(userPosition, bridge);
            printSeparation();
        }

        printWhetherUserDecisionIsCorrect(userPosition, moving, bridge);
        printMapEnd();
    }

    public void printLowerBridge(int userPosition, String moving, List<String> bridge){
        printMapStart();
        for(int i = 0; i < userPosition; i++){
            printOnePartOfLowerBridge(userPosition, bridge);
            printSeparation();
        }

        printWhetherUserDecisionIsCorrect(userPosition, moving, bridge);
        printMapEnd();
    }

    public void printWhetherUserDecisionIsCorrect(int userPosition, String moving, List<String> bridge){
        if(checkUserDirectionWithBridgeValue(userPosition, moving, bridge)){
            System.out.print(" O ");
            return;
        }
        System.out.print(" X ");
    }

    public boolean checkUserDirectionWithBridgeValue(int userPosition, String moving, List<String> bridge){
        if(bridge.get(userPosition) == moving){
            return true;
        }
        return false;
    }

    public void printOnePartOfUpperBridge(int index, List<String> bridge){
        if(bridge.get(index) == "U"){
            System.out.print(" O ");
            return;
        }

        System.out.print("   ");
    }

    public void printOnePartOfLowerBridge(int index, List<String> bridge){
        if(bridge.get(index) == "D"){
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

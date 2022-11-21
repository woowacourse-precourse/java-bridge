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
    public void printResult(User user,String direction, boolean checkDirection, List<String> bridge, boolean win) {
        System.out.println("최종 게임 결과");
        printMap(user.getUserPosition(), direction, checkDirection, bridge);
        printWinOrLose(win);
        printHowManyTimeTry(user);
    }

    public void printWinOrLose(boolean win){
        if(win == true){
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }

    public void printHowManyTimeTry(User user){
        System.out.printf("총 시도한 횟수: %d", user.getUserAttempt());
    }

    public void printUpperBridge(int userPosition, String userDecision, boolean checkDirection, List<String> bridge){
        printMapStart();
        for(int i = 0; i < userPosition; i++){
            printOnePartOfUpperBridge(i, bridge);
            printSeparation();
        }
        printWhetherUserDecisionIsCorrectInUpperBridge(userDecision, checkDirection);
        printMapEnd();
    }

    public void printLowerBridge(int userPosition, String userDecision, boolean checkDirection, List<String> bridge){
        printMapStart();
        for(int i = 0; i < userPosition; i++){
            printOnePartOfLowerBridge(i, bridge);
            printSeparation();
        }
        printWhetherUserDecisionIsCorrectInLowerBridge(userDecision, checkDirection);
        printMapEnd();
    }

    public void printWhetherUserDecisionIsCorrectInUpperBridge(String userDecision, boolean checkDirection){
        if(userDecision.equals("U")){
            printWhetherCheckDirectionIsCorrect(checkDirection);
            return;
        }
        System.out.print("   ");
    }

    public void printWhetherUserDecisionIsCorrectInLowerBridge(String userDecision, boolean checkDirection){
        if(userDecision.equals("D")){
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

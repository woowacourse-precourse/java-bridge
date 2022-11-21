package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printGetMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래 : D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(int trial, List<String> bridge, List<String> inputMove) {
        System.out.print("[");
        for(int i = 0; i<(trial+1);i++){
            printIndex(i);
            System.out.print(printUp(inputMove.get(i), BridgeGame.validMove(bridge.get(i),inputMove.get(i))));
        }
        System.out.println("]");
        System.out.print("[");
        for(int i = 0; i<(trial+1);i++){
            printIndex(i);
            System.out.print(printDown(inputMove.get(i), BridgeGame.validMove(bridge.get(i),inputMove.get(i))));
        }
        System.out.println("]");
    }
    public static void printIndex(int index){
        if(index != 0){
            System.out.print("|");
        }
    }
    public static String printMove(boolean valid){
        if(valid){
            return "O";
        }
        return "X";
    }
    public static String printUp(String move, boolean valid){
        if(move.equals("U")){
            return printMove(valid);
        }
        return " ";
    }
    public static String printDown(String move ,boolean valid){
        if(move.equals("D")){
            return printMove(valid);
        }
        return " ";
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

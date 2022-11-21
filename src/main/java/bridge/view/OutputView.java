package bridge.view;

import bridge.constant.PrintStatus;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Stack<String>> userBridge) {
        System.out.println("[ "+String.join(" | ", userBridge.get(0))+" ]" +"\n" +
                "[ " + String.join(" | ", userBridge.get(1)) +" ]" );
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Stack<String>> userBridge, String gameSuccess, int tryCount) {
        System.out.println(PrintStatus.ResGame.getDes());
        printMap(userBridge);
        System.out.println(PrintStatus.GameSuccessOrNot.getDes() + gameSuccess+ "\n" + PrintStatus.TotalGame.getDes() + tryCount);
    }

    public void printStart(){
        System.out.println(PrintStatus.GameStart.getDes());
    }

    public void printBridgeLength(){
        System.out.println(PrintStatus.InputBridgeLength.getDes());
    }

    public void printBridgeMove(){
        System.out.println(PrintStatus.BringMove.getDes());
    }

    public void printReTry(){
        System.out.println(PrintStatus.ReTryStart.getDes());
    }

    public void printGameSuccessOrNot(){
        System.out.println(PrintStatus.GameSuccessOrNot.getDes());
    }
}

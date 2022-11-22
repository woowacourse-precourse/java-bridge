package bridge;

import java.util.List;

import static bridge.messages.words.*;
import static bridge.messages.game.*;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart(){
        System.out.println(startGame);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> makingBridge) {
        System.out.println(makingBridge.get(0));
        System.out.println(makingBridge.get(1)+"\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> makingBridge, String status, int gameCnt) {
        System.out.println(resultGame);
        printMap(makingBridge);
        if(makingBridge.get(0).contains("X") || makingBridge.get(1).contains("X")) System.out.println(SorF+losing);
        if(!makingBridge.get(0).contains("X") && !makingBridge.get(1).contains("X")) System.out.println(SorF+success);
        System.out.println(gameCounting+gameCnt);
    }
}

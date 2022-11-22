package bridge.views;

import bridge.controller.BridgeController;
import bridge.domain.BridgeJudgmentCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public static List<String> Lst1 = new ArrayList<>();
    public static List<String> Lst2 = new ArrayList<>();


    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        if(BridgeController.playerStatus()) {
            System.out.println("O");
            return;
        }
        if(!BridgeController.playerStatus()) {
            System.out.println("X");
        }
//        BridgeJudgmentCase.BridgeJudgmentCaseReturn();

    }






    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

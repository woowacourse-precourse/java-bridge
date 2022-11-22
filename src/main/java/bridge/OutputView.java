package bridge;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    String start = "다리 건너기 게임을 시작합니다.";
    String finish = "최종 게임 결과";
    String isClear = "게임 성공 여부: ";
    String attemptNumber = "총 시도한 횟수: ";
    String success = "성공";
    String fail = "실패";

    BridgeViewMaker upBridge = new BridgeViewMaker("U");
    BridgeViewMaker downBridge = new BridgeViewMaker("D");

    public void ShowMessage(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> answer, String userUpDown, int blankNumber) {
        upBridge.resultBridge(answer, userUpDown, blankNumber);
        downBridge.resultBridge(answer, userUpDown, blankNumber);

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

}

package bridge.view;

import bridge.constants.OutputMessage;
import bridge.model.Bridge;
import bridge.model.BridgeSpace;
import bridge.model.Moved;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<String> upList;
    List<String> downList;

    public void printStartGame() {
        System.out.println(OutputMessage.START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        makeUpDownList(bridge);
        System.out.println("[ " + String.join(" | ",upList) + " ]");
        System.out.print("[ " + String.join(" | ",downList) + " ]");
        System.out.println();

    }

    private void makeUpDownList(Bridge bridge) {
        upList = new ArrayList<>();
        downList = new ArrayList<>();
        bridge.getMapfromBridge(upList,downList);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param tryCount
     * @param bridge
     */
    public void printResult(int tryCount, Bridge bridge) {
        System.out.println(OutputMessage.RESULT);
        printMap(bridge);
        if (bridge.getBridgeSpaces().get(bridge.getBridgeSpaces().size()-1).getMyMoved() == Moved.CAN) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: "+tryCount);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: "+tryCount);
    }


}

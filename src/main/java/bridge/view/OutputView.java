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
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        makeUpNdownList(bridge);
        System.out.println(String.join("",upList));
        System.out.println(String.join("",downList));
        System.out.println();
    }

    private void makeUpNdownList(Bridge bridge) {
        upList = new ArrayList<>();
        downList = new ArrayList<>();
        addSign("[ ");
        appendBridgeInfo(bridge.getBridgeSpaces().get(0));
        for (int idx= 1; idx < bridge.getBridgeSpaces().size(); idx++) {
            if (bridge.getBridgeSpaces().get(idx).getMyMoved() == Moved.NOTYET) break;
            addSign(" | ");
            appendBridgeInfo(bridge.getBridgeSpaces().get(idx));
        }
        addSign(" ]");
    }

    private void addSign(String s) {
        upList.add(s);
        downList.add(s);
    }

    private void appendBridgeInfo(BridgeSpace bridgeSpace) {

        if ((bridgeSpace.getUpOrDown() == "U"
                && bridgeSpace.getMyMoved() == Moved.CAN)
                || (bridgeSpace.getUpOrDown() == "D"
                && bridgeSpace.getMyMoved() == Moved.CANT) ) {
            upList.add(bridgeSpace.getMyMoved().getoOrX());
            downList.add(" ");
            return;
        }
        upList.add(" ");
        downList.add(bridgeSpace.getMyMoved().getoOrX());
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


    public void printStartGame() {
        System.out.println(OutputMessage.START_GAME);
    }
}

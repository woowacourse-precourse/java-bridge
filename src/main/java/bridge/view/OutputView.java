package bridge.view;

import bridge.constants.OutputMessage;
import bridge.model.Bridge;
import bridge.model.BridgeSpace;
import bridge.model.Moved;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        printFirstSpace(bridge.getBridgeSpaces().get(0));
        System.out.print("[ "+bridge.getBridgeSpaces().get(0).getMyMoved().getoOrX());
        for (int idx= 1; idx < bridge.getBridgeSpaces().size(); idx++) {
            if (bridge.getBridgeSpaces().get(idx).getMyMoved() == Moved.NOTYET) break;
            System.out.print(" | "+bridge.getBridgeSpaces().get(idx).getMyMoved().getoOrX());
        }
        System.out.println(" ]");
    }

    private void printFirstSpace(BridgeSpace bridgeSpace) {

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartGame() {
        System.out.println(OutputMessage.START_GAME);
    }
}

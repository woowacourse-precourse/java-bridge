package bridge.view;

import bridge.constant.Game;
import bridge.constant.IOMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStart() {
        System.out.println(IOMessage.START_GAME);
        System.out.println();
    }
    public void printMap(List<String> upBridge, List<String> downBridge) {
        printStatus(upBridge);
        printStatus(downBridge);
        System.out.println();
    }

    private void printStatus(List<String> bridgeStatus) {
        System.out.print(Game.BRIDGE_START);
        for(int i = 0; i < bridgeStatus.size(); i++) {
            System.out.print(bridgeStatus.get(i));
            if(i != bridgeStatus.size() -1) {
                System.out.print(Game.BRIDGE_BETWEEN);
            }
        }
        System.out.println(Game.BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

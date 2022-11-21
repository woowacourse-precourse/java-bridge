package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    Bridge bridge = new Bridge();
    BridgeGame bridgeGame = new BridgeGame();

    public Bridge initOutputBridge(String bridgeMove, boolean isMove) {
        bridge = bridgeGame.moveBridge(bridgeMove, isMove); // 출력할 다리 초기화
        printMap(); // 출력
        return bridge;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        for (List<String> bridgeList : bridge.getOutputBridge()) {
            System.out.print("[" + bridgeList.get(0));
            for (int i = 1; i < bridgeList.size(); i++) {
                System.out.print("|" + bridgeList.get(i));
            }
            System.out.println("]");
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge) {
        this.bridge = bridge;
        Message.printResult();
        printMap(); // 최종 다리 출력
        printIsGameSuccess(); // 게임 결과 출력
        printTryCount(); // 총 시도한 횟수 출력
    }

    public void printIsGameSuccess() {
        Message.printGame();
        if (Bridge.isGame()) {
            Message.gameSuccess();
            return;
        }
        Message.gameFail();
    }

    public void printTryCount() {
        Message.tryCount();
        System.out.println(bridge.getTryCount());
    }
}

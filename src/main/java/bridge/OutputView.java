package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    Application application = new Application();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Bridge> bridgeList, int bridgeCount) {
        for (Bridge bridge : bridgeList) {
            System.out.print("[");
            for (int i = 0; i < bridgeCount; i++) {
                System.out.print(bridge.getBridge().get(i));
            }
            System.out.println("]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Bridge> bridgeList, int bridgeCount) {
        Message.printResult();
        printMap(bridgeList, bridgeCount);
        printIsGameSuccess();
        printTryCount();
    }

    public void printIsGameSuccess() {
        Message.printGame();
        if (application.getIsGame()) {
            Message.gameSuccess();
            return;
        }
        Message.gameFail();
    }


}

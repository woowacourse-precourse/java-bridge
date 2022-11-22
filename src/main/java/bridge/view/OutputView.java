package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameStatistics;
import bridge.model.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private GameStatistics gameStatistics;
    private Bridge bridge;

    public OutputView(Bridge bridge) {
        this.bridge = bridge;
        this.gameStatistics = bridge.getGameStatistics();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        for (String value: bridge.getUpBridge()) {
            System.out.print(value + "");
        }
        System.out.println();
        for (String value: bridge.getDownBridge()) {
            System.out.print(value + "");
        }
        System.out.println("\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(MessageView.FINAL_GAME_RESULT.getMessage());
        printMap();
        System.out.println(MessageView.WHETHER_GAME_SUCCESS.getMessage() + gameStatistics.getGameResult());
        System.out.println(MessageView.TOTAL_ATTEMPTS.getMessage() + gameStatistics.getTotalTryCount());
    }
}
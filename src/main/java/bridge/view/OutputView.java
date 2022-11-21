package bridge.view;

import bridge.domain.Answer;
import bridge.domain.BridgeDirection;
import bridge.domain.GameStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    List<String> upBridge = new ArrayList<>();
    List<String> downBridge = new ArrayList<>();

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeDirection direction, Answer answer) {
        if (direction == BridgeDirection.UP) {
            upBridge.add(answer.getMessage());
            downBridge.add(" ");
        }
        if (direction == BridgeDirection.DOWN) {
            upBridge.add(" ");
            downBridge.add(answer.getMessage());
        }
        System.out.println(upBridge.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
        System.out.println(downBridge.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
    }

    public void reset() {
        upBridge.clear();
        downBridge.clear();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus, int tryCount) {
        System.out.println("최종 게임 결과");
        System.out.println(upBridge.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
        System.out.println(downBridge.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
        System.out.println("게임 성공 여부: " + gameStatus.getMessage());
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}

package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        List<List<String>> gameProgress = game.gameProgress;
        List<String> upBridge = makeOneBridge(gameProgress, "U");
        List<String> downBridge = makeOneBridge(gameProgress, "D");
        printOneBridge(upBridge);
        printOneBridge(downBridge);
    }

    private void printOneBridge(List<String> oneBridge) {
        System.out.print("[ ");
        for (int i = 0; i < oneBridge.size(); i++) {
            System.out.print(oneBridge.get(i));
            if (i == oneBridge.size() - 1) {
                continue;
            }
            System.out.print(" | ");
        }
        System.out.println(" ]");
    }

    private List<String> makeOneBridge(List<List<String>> gameProgress, String upOrDown) {
        List<String> oneBridge = new ArrayList<>();
        for (int i = 0; i < gameProgress.size(); i++) {
            if (upOrDown.equals(gameProgress.get(i).get(0))) {
                oneBridge.add(gameProgress.get(i).get(1));
                continue;
            }
            oneBridge.add(" ");
        }
        return oneBridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game, String result, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(game);
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}

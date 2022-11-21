package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.ResultMap;
import bridge.service.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> maps, Command command) {
        int mapSize = maps.get(ResultMap.DIRECTION_MAP.index()).size();
        System.out.print("[");
        for (int index = Bridge.START_INDEX.getValue(); index < mapSize; index++) {
            printMoveOrBlank(maps, index, command);
            printVerticalBar(mapSize, index);
        }
        System.out.println("]");
    }

    private void printMoveOrBlank(List<List<String>> maps, int index, Command move) {
        List<String> directionMap = maps.get(ResultMap.DIRECTION_MAP.index());
        List<String> signMap = maps.get(ResultMap.SIGN_MAP.index());
        if (directionMap.get(index).equals(move.getValue())) {
            System.out.printf(" %s ", signMap.get(index));
            return;
        }
        System.out.print("   ");
    }

    private void printVerticalBar(int bridgeSize, int index) {
        if (index != bridgeSize - 1) {
            System.out.print("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printIsGameCompleted(bridgeGame.isGameCompleted());
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTotalAttempt());
    }

    public void printResultHeader() {
        System.out.println("최종 게임 결과");
    }

    private void printIsGameCompleted(boolean isGameCompleted) {
        if (isGameCompleted) {
            System.out.println("\n게임 성공 여부: 성공");
            return;
        }
        System.out.println("\n게임 성공 여부: 실패");
    }

    public void printBridgeSizeInputError() {
        System.out.println("[ERROR] 다리 길이는 3~20 사이의 값을 가져야 합니다. 다시 입력해 주십시오.");
    }

    public void printPlayerMoveInputError() {
        System.out.println("[ERROR] 이동 방향은 'U'/'D' 중 한가지로 입력되어야 합니다. 다시 입력해 주십시오.");
    }

    public void printRetryOrQuitInputError() {
        System.out.println("[ERROR] 입력값은 'R'/'Q' 중 한가지로 입력되어야 합니다. 다시 입력해 주십시오.");
    }
}
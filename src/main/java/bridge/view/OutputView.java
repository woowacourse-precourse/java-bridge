package bridge.view;

import bridge.domain.Cell;
import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printGuideForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printGuideForMoveDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGuideForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Cell> bridgeStatus) {
        StringBuilder upperMap = createUpperMap(bridgeStatus);
        StringBuilder lowerMap = createLowerMap(bridgeStatus);
        System.out.println(upperMap);
        System.out.println(lowerMap);
    }

    private StringBuilder createUpperMap(List<Cell> bridgeStatus) {
        StringBuilder up = new StringBuilder("[");
        for (Cell cell : bridgeStatus) {
            up.append(createUpperCell(cell));
        }
        up.delete(up.length() - 1, up.length());
        return up.append("]");
    }

    private StringBuilder createLowerMap(List<Cell> bridgeStatus) {
        StringBuilder down = new StringBuilder("[");
        for (Cell cell : bridgeStatus) {
            down.append(createLowerCell(cell));
        }
        down.delete(down.length() - 1, down.length());
        return down.append("]");
    }

    private String createLowerCell(Cell cell) {
        if (cell.getDirection().equals("D")) {
            return " " + cell.getStatus() + " |";
        }
        return "   |";
    }

    private String createUpperCell(Cell cell) {
        if (cell.getDirection().equals("U")) {
            return " " + cell.getStatus() + " |";
        }
        return "   |";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param gameResult
     */
    public void printResult(GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printMap(gameResult.getBridgeStatus());
        System.out.println();

        System.out.println("게임 성공 여부: " + gameResult.getStatus().getName());
        System.out.println("총 시도한 횟수: " + gameResult.getAttemptCount());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

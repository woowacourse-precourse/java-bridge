package bridge;

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
        StringBuilder upStringBuilder = createUpStringBuilder(bridgeStatus);
        StringBuilder downStringBuilder = createDownStringBuilder(bridgeStatus);
        System.out.println(upStringBuilder);
        System.out.println(downStringBuilder);
    }

    private StringBuilder createUpStringBuilder(List<Cell> bridgeStatus) {
        StringBuilder up = new StringBuilder("[");
        for (Cell cell : bridgeStatus) {
            if (cell.getDirection().equals("U")) {
                up.append(" ").append(cell.getStatus()).append(" |");
                continue;
            }
            up.append("   |");
        }
        up.delete(up.length() - 1, up.length());
        return up.append("]");
    }

    private StringBuilder createDownStringBuilder(List<Cell> bridgeStatus) {
        StringBuilder down = new StringBuilder("[");
        for (Cell cell : bridgeStatus) {
            if (cell.getDirection().equals("D")) {
                down.append(" ").append(cell.getStatus()).append(" |");
                continue;
            }
            down.append("   |");
        }
        down.delete(down.length() - 1, down.length());
        return down.append("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param gameResult
     */
    public void printResult(GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printMap(gameResult.getBridgeStatus());
        System.out.println();

        System.out.println("게임 성공 여부: " + gameResult.getStatus().getName());
        System.out.println("총 시도한 횟수: " + gameResult.getAttemptCount());
    }

}

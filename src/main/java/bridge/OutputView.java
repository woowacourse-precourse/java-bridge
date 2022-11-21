package bridge;

import static bridge.Bridge.UP_BLOCK_MARK;
import static bridge.Bridge.DOWN_BLOCK_MARK;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<History> moveHistory) {
        int distance = moveHistory.size();
        printRowOfMap(getRowMoveHistory(moveHistory, UP_BLOCK_MARK), distance);
        printRowOfMap(getRowMoveHistory(moveHistory, DOWN_BLOCK_MARK), distance);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("\n최종 게임 결과");
        printMap(bridgeGame.getMoveHistory());
        System.out.println("\n게임 성공 여부: " + toGameSuccessWord(bridgeGame.isWin()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    private void printRowOfMap(List<History> rowMoveHistory, int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ")
                .append(makeRowMoveBody(rowMoveHistory, distance))
                .append(" ]");
        System.out.println(stringBuilder.toString());
    }

    private List<History> getRowMoveHistory(List<History> moveHistory, String rowMark) {
        return moveHistory.stream()
                .filter(history -> history.isSameMoveDirection(rowMark))
                .collect(Collectors.toUnmodifiableList());
    }

    private String makeRowMoveBody(List<History> rowMoveHistory, int distance) {
        return IntStream.range(0, distance)
                .mapToObj(position -> makeMoveBlockBody(position, rowMoveHistory))
                .collect(Collectors.joining(" | "));
    }

    private String makeMoveBlockBody(int column, List<History> rowMoveHistory) {
        return findMoveHistoryAtColumn(column, rowMoveHistory)
                .map(moveHistory -> toSymbol(moveHistory.isMoveSucess()))
                .orElse(" ");
    }

    private Optional<History> findMoveHistoryAtColumn(int column, List<History> rowMoveHistory) {
        return rowMoveHistory.stream()
                .filter(history -> history.isSamePosition(column))
                .findFirst();
    }

    private String toSymbol(boolean moveSuccess) {
        if (moveSuccess) {
            return "O";
        }
        return "X";
    }

    private String toGameSuccessWord(boolean gameSuccess) {
        if (gameSuccess) {
            return "성공";
        }
        return "실패";
    }

    public void printBridgeGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInput() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printBridgeMoveDirectionInput() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommandInput() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}

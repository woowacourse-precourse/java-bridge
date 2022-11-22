package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * @param bridge 다리의 상태
     * @param move   입력의 상태
     *               <p>
     *               현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *               <p>
     *               출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> move) {
        bridgeStateValidate(bridge, move);
        StringBuilder upLine = new StringBuilder("["), downLine = new StringBuilder("[");
        List<StringBuilder> lines = Arrays.asList(upLine, downLine);
        addBridgeMap(lines, move);
        addLastBridgeMap(lines, bridge.get(move.size() - 1), move.get(move.size() - 1));
        System.out.println(upLine.toString());
        System.out.println(downLine.toString());
    }

    /**
     * @param lines 출력할 다리 상태
     * @param move  현재까지의 입력 커맨드
     *              <p>
     *              마지막을 제외한 부분의 입력을 출력으로 변환한다.
     */
    private void addBridgeMap(List<StringBuilder> lines, List<String> move) {
        for (int i = 0; i < move.size() - 1; i++) {
            if (move.get(i).equals("U")) {
                lines.get(0).append(" O |");
                lines.get(1).append("   |");
                continue;
            }
            lines.get(0).append("   |");
            lines.get(1).append(" O |");
        }
    }


    /**
     * @param lines      출력할 다리 상태
     * @param lastBridge 마지막 다리 위치
     * @param lastMove   마지막 이동 위치
     *                   <p>
     *                   마지막을 제외한 부분의 입력을 출력으로 변환한다.
     */
    private void addLastBridgeMap(List<StringBuilder> lines, String lastBridge, String lastMove) {
        char result = match(lastBridge, lastMove);
        if (lastMove.equals("U")) {
            lines.get(0).append(" " + result + " ]");
            lines.get(1).append("   ]");
            return;
        }
        lines.get(0).append("   ]");
        lines.get(1).append(" " + result + " ]");
    }

    /**
     * @param first  비교할 문자열 1
     * @param second 비교할 문자열 2
     * @return 서로 맞는 경우 O, 다르면 X 반환
     * <p>
     * 문자열을 비교해 맞으면 O, 틀리면 X를 반환한다.
     */
    private char match(String first, String second) {
        if (first.equals(second)) return 'O';
        return 'X';
    }

    /**
     * @param bridge 다리 위치
     * @param move   이동 위치
     * @Exception IllegalStateException 마지막이 아닌 중간에서 일치하지 않는 경우 예외를 던진다.
     * <p>
     * 현재까지의 이동 상태를 검증한다.
     */
    private void bridgeStateValidate(List<String> bridge, List<String> move) {
        for (int i = 0; i < move.size() - 1; i++) {
            if (!bridge.get(i).equals(move.get(i)))
                throw new IllegalStateException("내부 상태이상: 중간에 일치하지 않는 부분이 있습니다.");
        }
    }

    /**
     * @param bridge 다리 상태
     * @param move   현재까지의 입력 커맨드
     * @param count  시도 횟수
     *               <p>
     *               게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *               <p>
     *               출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> move, int count) {
        System.out.println("최종 게임 결과");
        printMap(bridge, move);
        System.out.println();
        if (bridge.equals(move)) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + count);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMoveMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printRestartMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printExceptionMessage(Exception exception) {
        final String startMessage = "[ERROR]";
        System.out.println(startMessage + " " + exception.getMessage());
    }
}

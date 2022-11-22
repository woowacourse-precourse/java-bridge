package bridge;

import java.util.ArrayList;
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
        addBridgeMap(upLine, downLine, move);
        addLastBridgeMap(upLine, downLine, bridge.get(move.size() - 1), move.get(move.size() - 1));
        System.out.println(upLine.toString());
        System.out.println(downLine.toString());
    }

    /**
     * @param upLine      다리 건너기 결과의 윗부분에 해당하는 문자열
     * @param downLine    다리 건너기 결과의 아랫부분에 해당하는 문자열
     * @param bridgeState 마지막 입력 커맨드 위치에 해당하는 다리의 상태
     * @param moveCommand 마지막 입력 커맨드
     *                    <p>
     *                    마지막 부분의 입력을 출력으로 변환한다.
     */
    private void addLastBridgeMap(StringBuilder upLine, StringBuilder downLine, String bridgeState, String moveCommand) {
        String isCorrect = "X";
        if (moveCommand.equals(bridgeState))
            isCorrect = "O";

        if (moveCommand.equals("U")) {
            insertResult(upLine, downLine, " " + isCorrect + " ]", "   ]");
            return;
        }
        insertResult(upLine, downLine, "   ]", " " + isCorrect + " ]");
    }

    /**
     * @param upLine     다리 건너기 결과의 윗부분에 해당하는 문자열
     * @param downLine   다리 건너기 결과의 아랫부분에 해당하는 문자열
     * @param upString   윗부분의 문자열에 추가할 문자열
     * @param downString 아랫부분의 문자열에 추가할 문자열
     *                   <p>
     *                   위아래 문자열과 각각 추가할 문자열을 입력받아 추가한다.
     */
    private void insertResult(StringBuilder upLine, StringBuilder downLine, String upString, String downString) {
        upLine.append(upString);
        downLine.append(downString);
    }

    /**
     * @param upLine   다리 건너기 결과의 윗부분에 해당하는 문자열
     * @param downLine 다리 건너기 결과의 아랫부분에 해당하는 문자열
     * @param move     현재까지의 입력 커맨드
     *                 <p>
     *                 마지막을 제외한 부분의 입력을 출력으로 변환한다.
     */
    private void addBridgeMap(StringBuilder upLine, StringBuilder downLine, List<String> move) {
        for (int i = 0; i < move.size() - 1; i++) {
            if (move.get(i).equals("U")) {
                upLine.append(" O |");
                downLine.append("   |");
                continue;
            }
            upLine.append("   |");
            downLine.append(" O |");
        }
    }

    /**
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
}

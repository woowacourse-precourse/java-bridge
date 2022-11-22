package bridge.view;

import bridge.domain.model.Direction;
import bridge.domain.BridgeTranslator;
import bridge.domain.model.PieceMove;

import java.util.Stack;

/**
 * 콘솔용 다리 출력 기능을 지원하는 {@link BridgeTranslator} 구현체
 */
public class BridgeConsoleTranslator implements BridgeTranslator {

    public static final String DELIMITER = "|";
    public static final String START_OF_BRIDGE = "[";
    public static final String END_OF_BRIDGE = "]";
    public static final String SUCCESS_MOVE = " O ";
    public static final String FAIL_MOVE = " X ";
    public static final String NEXT_LINE = "\n";
    public static final String EMPTY_CELL = "   ";

    /**
     * 콘솔에서 출력 가능한 형태로 변환
     * @param moveTrace 누적된 이동 결과
     * @return 다리 출력 결과
     * @see PieceMove
     * @see BridgeTranslator
     */
    @Override
    public String getPrintable(Stack<PieceMove> moveTrace) {
        StringBuilder upLine = new StringBuilder();
        StringBuilder downLine = new StringBuilder();

        recordStartOfBridge(upLine, downLine);
        recordFirstCellWithoutDelimiter(moveTrace, upLine, downLine);
        recordRemainCellsWithDelimiter(moveTrace, upLine, downLine);
        recordEndOfBridge(upLine, downLine);

        return mergeLines(upLine, downLine);
    }

    /**
     * 첫 번째 칸에 대해 구분자 없이 기록
     * @param moveTrace 누적된 이동 결과
     * @param upLine 윗줄의 빌더
     * @param downLine 아랫줄의 빌더
     */
    private static void recordFirstCellWithoutDelimiter(Stack<PieceMove> moveTrace, StringBuilder upLine, StringBuilder downLine) {
        if (!moveTrace.isEmpty()) {
            upLine.append(traceToPrintable(moveTrace.get(0), Direction.UP));
            downLine.append(traceToPrintable(moveTrace.get(0), Direction.DOWN));
        }
    }

    /**
     * 나머지 칸에 대해 구분자 포함하여 기록
     * @param moveTrace 누적된 이동 결과
     * @param upLine 윗줄의 빌더
     * @param downLine 아랫줄의 빌더
     */
    private static void recordRemainCellsWithDelimiter(Stack<PieceMove> moveTrace, StringBuilder upLine, StringBuilder downLine) {
        for (int idx = 1; idx < moveTrace.size(); idx++) {
            upLine.append(DELIMITER).append(traceToPrintable(moveTrace.get(idx), Direction.UP));
            downLine.append(DELIMITER).append(traceToPrintable(moveTrace.get(idx), Direction.DOWN));
        }
    }

    /**
     * 다리의 시작을 알리는 기호 추가
     * @param upLine 윗줄의 빌더
     * @param downLine 아랫줄의 빌더
     */
    private static void recordStartOfBridge(StringBuilder upLine, StringBuilder downLine) {
        upLine.append(START_OF_BRIDGE);
        downLine.append(START_OF_BRIDGE);
    }

    /**
     * 다리의 끝을 알리는 기호 추가
     * @param upLine 윗줄의 빌더
     * @param downLine 아랫줄의 빌더
     */
    private static void recordEndOfBridge(StringBuilder upLine, StringBuilder downLine) {
        upLine.append(END_OF_BRIDGE);
        downLine.append(END_OF_BRIDGE);
    }

    /**
     * 위 / 아래 두 개의 줄을 합친 문자열 반환
     * @param upLine 윗줄의 빌더
     * @param downLine 아랫줄의 빌더
     * @return 최종 문자열
     */
    private static String mergeLines(StringBuilder upLine, StringBuilder downLine) {
        return upLine.append(NEXT_LINE).append(downLine).toString();
    }

    /**
     * 한 칸을 표현하는 문자열을 반환
     * @param move 한 칸의 이동 기록
     * @param linePosition 기록하고자 하는 줄
     * @return 한 칸을 나타내는 문자열
     */
    private static String traceToPrintable(PieceMove move, Direction linePosition) {
        if (move.getDirection() != linePosition) {
            return EMPTY_CELL;
        }
        return traceToResult(move);
    }

    /**
     * 이동 성공 여부로 출력할 칸을 표현
     * @param move 한 칸의 이동 기록
     * @return 한 칸 속 표시될 문자열
     */
    private static String traceToResult(PieceMove move) {
        if (move.getSuccess()) {
            return SUCCESS_MOVE;
        }
        return FAIL_MOVE;
    }

}

package bridge.view;

import bridge.model.MoveRecord;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BRIDGE_FORMAT_PREFIX = "[ ";
    private static final String BRIDGE_FORMAT_POSTFIX = " ]";
    private static final String BRIDGE_FORMAT_SEPARATOR = " | ";

    private static final String BRIDGE_RESULT_SUCCESS = "O";
    private static final String BRIDGE_RESULT_FAIL = "X";
    private static final String BRIDGE_RESULT_NONE = " ";

    private static final String BRIDGE_CROSS_SUCCESS = "성공";
    private static final String BRIDGE_CROSS_FAIL = "실패";

    private static final String BRIDGE_UPPER = "U";
    private static final String BRIDGE_LOWER = "D";

    private static final String ERROR_FORMAT_PREFIX = "[ERROR] ";


    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printError(String msg) {
        System.out.println(ERROR_FORMAT_PREFIX + msg);
    }

    public void printMap(List<MoveRecord> records) {
        System.out.println(printFormattedLine(records, BRIDGE_UPPER));
        System.out.println(printFormattedLine(records, BRIDGE_LOWER));
    }

    private String printFormattedLine(List<MoveRecord> records, String direction) {
        String result = "";
        result += BRIDGE_FORMAT_PREFIX;
        result += printRecord(records, direction);
        result += BRIDGE_FORMAT_POSTFIX;
        return result;
    }

    private String printRecord(List<MoveRecord> records, String direction) {
        return records.stream()
                .map(record -> printStep(record, direction))
                .collect(Collectors.joining(BRIDGE_FORMAT_SEPARATOR));
    }

    private String printStep(MoveRecord record, String direction) {
        if (record.getStep().equals(direction)) {
            return printOX(record);
        }
        return BRIDGE_RESULT_NONE;
    }

    private String printOX(MoveRecord record) {
        if (record.isSuccess()) {
            return BRIDGE_RESULT_SUCCESS;
        }
        return BRIDGE_RESULT_FAIL;
    }

    public void printFinalResultTitle() {
        System.out.println("최종 게임 결과");
    }

    public void printSuccess(boolean success) {
        String result = "게임 성공 여부: ";
        System.out.println(result + winOrLose(success));
    }

    private String winOrLose(boolean success) {
        if (success) {
            return BRIDGE_CROSS_SUCCESS;
        }
        return BRIDGE_CROSS_FAIL;
    }

    public void printTrial(int n) {
        System.out.println("총 시도한 횟수: " + n);
    }
}

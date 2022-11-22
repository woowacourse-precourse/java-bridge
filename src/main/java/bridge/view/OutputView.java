package bridge.view;

import bridge.model.MoveRecord;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public void printMap(List<MoveRecord> records) {
        System.out.println(printFormattedLine(records, "U"));
        System.out.println(printFormattedLine(records, "D"));
    }

    private String printFormattedLine(List<MoveRecord> records, String direction) {
        String result = "";
        result += "[ ";
        result += printRecord(records, direction);
        result += " ]";
        return result;
    }

    private String printRecord(List<MoveRecord> records, String direction) {
        return records.stream()
                .map(record -> printStep(record, direction))
                .collect(Collectors.joining(" | "));
    }

    private String printStep(MoveRecord record, String direction) {
        if (record.getStep().equals(direction)) {
            return printOX(record);
        }
        return " ";
    }

    private String printOX(MoveRecord record) {
        if (record.isSuccess()) {
            return "O";
        }
        return "X";
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
            return "성공";
        }
        return "실패";
    }

    public void printTrial(int n) {
        System.out.println("총 시도한 횟수: " + n);
    }
}

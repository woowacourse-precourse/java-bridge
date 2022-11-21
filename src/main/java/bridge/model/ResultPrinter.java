package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

abstract class ResultPrinter {

    public static final String RIGHT_SIGN = "O";
    public static final String RESULT_DELIMITER = " | ";
    public static final String DEFAULT_SIGN = " ";
    public static final String FORMAT_RESULT = "[ %s ]\n";
    protected final List<Position> passingRout;

    ResultPrinter(List<Position> passingRout) {
        this.passingRout = passingRout;
    }

    public static ResultPrinter createResultPrinter(Boolean success, List<Position> passingRout) {
        if (success) {
            return new SuccessResultPrinter(passingRout);
        }
        return new FailureResultPrinter(passingRout);
    }

    String print() {
        return this.getResultFormat(this.getResult(Position.UP)) + this.getResultFormat(this.getResult(Position.DOWN));
    }

    protected String getResultFormat(String result) {
        return String.format(FORMAT_RESULT, result);
    }

    protected String getResult(Position targetPosition) {
        return this.passingRout.stream()
                .map(position -> this.isSamePosition(position, targetPosition))
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String isSamePosition(Position position, Position targetPosition) {
        if (position.equals(targetPosition)) {
            return RIGHT_SIGN;
        }
        return DEFAULT_SIGN;
    }
}

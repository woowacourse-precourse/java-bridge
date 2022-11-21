package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

abstract class ResultPrinter {
    public static final String DIRECTION_UP = "U";
    public static final String DIRECTION_DOWN = "D";
    public static final String RIGHT_SIGN = "O";
    public static final String RESULT_DELIMITER = " | ";
    public static final String DEFAULT_SIGN = " ";
    public static final String FORMAT_RESULT = "[ %s ]\n";
    protected final List<String> directions;

    ResultPrinter(List<String> directions) {
        this.directions = directions;
    }

    public static ResultPrinter createResultPrinter(Boolean success, List<String> directions) {
        if (success) {
            return new SuccessResultPrinter(directions);
        }
        return new FailureResultPrinter(directions);
    }

    abstract String print();

    protected String getResultFormat(String result) {
        return String.format(FORMAT_RESULT, result);
    }

    protected String getResult(String targetDirection) {
        return directions.stream()
                .map(direction -> this.isSame(direction,targetDirection))
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String isSame(String direction, String target) {
        if (direction.equals(target)) {
            return RIGHT_SIGN;
        }
        return DEFAULT_SIGN;
    }
}

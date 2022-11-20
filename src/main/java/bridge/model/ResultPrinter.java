package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

abstract class ResultPrinter {
    public static final String DIRECTION_UP = "U";
    public static final String DIRECTION_DOWN = "D";
    public static final String RIGHT_SIGN = "O";
    public static final String WRONG_SIGN = "X";
    public static final int CHANGE_INDEX_ADD_ONE = 1;
    public static final String RESULT_DELIMITER = " | ";
    public static final String DEFAULT_SIGN = " ";
    public static final String FORMAT_RESULT = "[ %s ]\n";
    protected final List<String> directions;

    ResultPrinter(List<String> directions) {
        this.directions = directions;
    }

    abstract String print();

    protected String getResultFormat(String result) {
        return String.format(FORMAT_RESULT, result);
    }

    protected String getDownResult() {
        return directions.stream()
                .map(this::isDown)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    protected String getUpResult() {
        return directions.stream()
                .map(this::isUp)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String isDown(String direction) {
        if (direction.equals(DIRECTION_DOWN)) {
            return RIGHT_SIGN;
        }
        return DEFAULT_SIGN;
    }

    private String isUp(String direction) {
        if (direction.equals(DIRECTION_UP)) {
            return RIGHT_SIGN;
        }
        return DEFAULT_SIGN;
    }
}

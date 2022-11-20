package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    public static final String DIRECTION_UP = "U";
    public static final String DIRECTION_DOWN = "D";
    public static final String RIGHT_SIGN = "O";
    public static final String WRONG_SIGN = "X";
    public static final int CHANGE_INDEX_ADD_ONE = 1;
    public static final String RESULT_DELIMITER = " | ";
    public static final String DEFAULT_SIGN = " ";
    public static final String FORMAT_RESULT = "[ %s ]\n";
    private final List<String> directions;

    Player() {
        this.directions = new ArrayList<>();
    }

    int move(String direction) {
        directions.add(direction);
        return directions.size();
    }

    boolean isCompleted(int size) {
        return directions.size() == size;
    }

    boolean isStartStatus() {
        return directions.isEmpty();
    }

    //TODO  print 분리
    String printFailureResult() {
        StringBuilder result = new StringBuilder();
        getFailureResult(getUpResult(), result, DIRECTION_UP);
        getFailureResult(getDownResult(), result, DIRECTION_DOWN);
        return result.toString();
    }

    private void getFailureResult(String rightUpResult, StringBuilder result, String U) {
        result.append(getResultFormat(rightUpResult));
        if (directions.get(directions.size() - 1).equals(U)) {
            result.replace(result.lastIndexOf(RIGHT_SIGN), result.lastIndexOf(RIGHT_SIGN) + CHANGE_INDEX_ADD_ONE,
                    WRONG_SIGN);
        }
    }


    String printSuccessResult() {
        return getResultFormat(getUpResult())
                + getResultFormat(getDownResult());
    }

    private String getResultFormat(String result) {
        return String.format(FORMAT_RESULT, result);
    }

    private String getDownResult() {
        return directions.stream()
                .map(this::isDown)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String getUpResult() {
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

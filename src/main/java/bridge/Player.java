package bridge;

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
    public static final String DEAULT_SIGN = " ";
    public static final String FORMAT_RESULT = "[ %s ]\n";
    private final List<String> directions;

    public Player() {
        this.directions = new ArrayList<>();
    }

    public int move(String direction) {
        directions.add(direction);
        return directions.size();
    }

    public boolean isCompleted(int size) {
        return directions.size() == size;
    }

    public boolean isStartStatus() {
        return directions.isEmpty();
    }

    String printWrongResult() {
        StringBuilder result = new StringBuilder();
        extracted(rightUpResult(), result, DIRECTION_UP);
        extracted(rightDownResult(), result, DIRECTION_DOWN);
        return result.toString();
    }

    private void extracted(String rightUpResult, StringBuilder result, String U) {
        result.append(getResultFormat(rightUpResult));
        if (directions.get(directions.size() - 1).equals(U)) {
            result.replace(result.lastIndexOf(RIGHT_SIGN), result.lastIndexOf(RIGHT_SIGN) + CHANGE_INDEX_ADD_ONE,
                    WRONG_SIGN);
        }
    }


    public String printRightResult() {
        return getResultFormat(rightUpResult())
                + getResultFormat(rightDownResult());
    }

    private String getResultFormat(String result) {
        return String.format(FORMAT_RESULT, result);
    }

    private String rightDownResult() {
        return directions.stream()
                .map(this::isDown)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String rightUpResult() {
        return directions.stream()
                .map(this::isUp)
                .collect(Collectors.joining(RESULT_DELIMITER));
    }

    private String isDown(String direction) {
        if (direction.equals(DIRECTION_DOWN)) {
            return RIGHT_SIGN;
        }
        return DEAULT_SIGN;
    }

    public String isUp(String direction) {
        if (direction.equals(DIRECTION_UP)) {
            return RIGHT_SIGN;
        }
        return DEAULT_SIGN;
    }
}

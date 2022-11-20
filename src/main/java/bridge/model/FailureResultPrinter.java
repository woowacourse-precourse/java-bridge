package bridge.model;

import java.util.List;

public class FailureResultPrinter extends ResultPrinter {

    FailureResultPrinter(List<String> directions) {
        super(directions);
    }

    @Override
    String print() {
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
}

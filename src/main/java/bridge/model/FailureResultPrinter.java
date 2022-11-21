package bridge.model;

import java.util.List;

public class FailureResultPrinter extends ResultPrinter {

    public static final String WRONG_SIGN = "X";
    public static final int INDEX_SIZE_DIFFERENT = 1;
    public static final int BEGIN_INDEX = 0;

    FailureResultPrinter(List<Position> passingRout) {
        super(passingRout);
    }

    @Override
    public String getResult(Position targetPosition) {
        String result = super.getResult(targetPosition);
        if (getEndPosition().equals(targetPosition)) {
            return replaceSignOToX(result);
        }
        return result;
    }

    private Position getEndPosition() {
        return passingRout.get(getEndIndex(passingRout.size()));
    }

    private static String replaceSignOToX(String result) {
        return removeLastChar(result) + WRONG_SIGN;
    }

    private static String removeLastChar(String result) {
        return result.substring(BEGIN_INDEX, getEndIndex(result.length()));
    }

    private static int getEndIndex(int size) {
        return size - INDEX_SIZE_DIFFERENT;
    }
}

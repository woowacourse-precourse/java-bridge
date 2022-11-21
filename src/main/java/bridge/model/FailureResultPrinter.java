package bridge.model;

import java.util.List;

public class FailureResultPrinter extends ResultPrinter {

    public static final String WRONG_SIGN = "X";
    public static final int INDEX_SIZE_DIFFERENT = 1;
    public static final int BEGIN_INDEX = 0;

    FailureResultPrinter(List<String> directions) {
        super(directions);
    }

    @Override
    public String getResult(String direction) {
        String result = super.getResult(direction);
        if (getEndChar().equals(direction)){
            return replaceSignOToX(result);
        }
        return result;
    }

    private String getEndChar() {
        return directions.get(getEndIndex(directions.size()));
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

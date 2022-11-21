package bridge.model;

import java.util.List;

public class FailureResultPrinter extends ResultPrinter {

    public static final String WRONG_SIGN = "X";
    public static final int LAST_INDEX_AND_SIZE_DIFFERENT = 1;
    public static final int BEGIN_INDEX = 0;

    FailureResultPrinter(List<String> directions) {
        super(directions);
    }

    @Override
    public String getResult(String direction) {
        String result = super.getResult(direction);
        if (directions.get(getEndIndex(directions.size())).equals(direction)){
            return replaceSignToX(result);
        }
        return result;
    }

    private static String replaceSignToX(String result) {
        String substring = result.substring(BEGIN_INDEX, getEndIndex(result.length()));
        return substring + WRONG_SIGN;
    }

    private static int getEndIndex(int size) {
        return size - LAST_INDEX_AND_SIZE_DIFFERENT;
    }
}

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
        String result = this.getSuccessResult(targetPosition);
        if (isEqualsEndPosition(targetPosition)) {
            return this.replaceSignOToX(result);
        }
        return this.getSuccessResult(targetPosition);
    }

    private String getSuccessResult(Position targetPosition) {
        return super.getResult(targetPosition);
    }

    private boolean isEqualsEndPosition(Position targetPosition) {
        return this.getEndPosition().equals(targetPosition);
    }

    private Position getEndPosition() {
        return this.passingRout.get(this.getEndIndex(passingRout.size()));
    }

    private String replaceSignOToX(String result) {
        return this.removeLastChar(result) + WRONG_SIGN;
    }

    private String removeLastChar(String result) {
        return result.substring(BEGIN_INDEX, this.getEndIndex(result.length()));
    }

    private int getEndIndex(int size) {
        return size - INDEX_SIZE_DIFFERENT;
    }
}

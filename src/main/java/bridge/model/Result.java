package bridge.model;

public class Result {
    private final String selectDirection;
    private final boolean isSuccess;

    public Result(String selectDirection, boolean isSuccess) {
        this.selectDirection = selectDirection;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public String getUpper() {
        if (selectDirection.equals("U") && isSuccess) {
            return "O";
        }
        if (selectDirection.equals("U")) {
            return "X";
        }
        return " ";
    }

    public String getDown() {
        if (selectDirection.equals("D") && isSuccess) {
            return "O";
        }
        if (selectDirection.equals("D")) {
            return "X";
        }
        return " ";
    }

    public boolean isSameResult(Result result) {
        return this.selectDirection.equals(result.selectDirection) && this.isSuccess == result.isSuccess;
    }
}

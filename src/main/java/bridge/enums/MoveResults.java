package bridge.enums;

public enum MoveResults {
    SUCCESS(true, "O"),
    FAILURE(false, "X");

    private boolean isSuccess;
    private String result;

    MoveResults(boolean isSuccess, String result) {
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public static String getResult(MoveResults moveResults) {
        return moveResults.result;
    }

    public static MoveResults valueOf(boolean isSuccess) {
        for (MoveResults moveResults : MoveResults.values()) {
            if (moveResults.isSuccess == isSuccess) {
                return moveResults;
            }
        }
        return null;
    }
}

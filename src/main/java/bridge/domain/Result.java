package bridge.domain;

public enum Result {

    SUCCESS("O", "성공"),
    FAIL("X", "실패");

    private String symbol;
    private String resultOfKorean;

    Result(String symbol, String resultOfKorean) {
        this.symbol = symbol;
        this.resultOfKorean = resultOfKorean;
    }

    public String getResultSymbol() {
        return this.symbol;
    }

    public String getResultOfKorean() {
        return this.resultOfKorean;
    }

    public static Result getResultBySuccess(boolean isSuccess) {
        if (isSuccess) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

}

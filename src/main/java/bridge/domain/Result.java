package bridge.domain;

public class Result {
    private Boolean isSuccess;
    private Integer tryCnt;
    private FootPrint finalResult;

    public Result() {
        isSuccess = false;
        tryCnt = 0;
    }

    public void recordFail(FootPrint finalResult) {
        isSuccess = false;
        tryCnt += 1;
        this.finalResult = finalResult;
    }

    public void recordSuccess(FootPrint finalResult) {
        isSuccess = true;
        tryCnt += 1;
        this.finalResult = finalResult;
    }
}

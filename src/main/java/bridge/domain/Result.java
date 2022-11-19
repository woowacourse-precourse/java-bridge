package bridge.domain;

public class Result {
    private Boolean isSuccess;
    private Integer tryCnt;
    private FootPrint footPrint;

    public Result() {
        isSuccess = false;
        tryCnt = 0;
        footPrint = new FootPrint();
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Integer getTryCnt() {
        return tryCnt;
    }

    public FootPrint getFootPrint() {
        return footPrint;
    }

    public Integer askTurn() {
        return footPrint.getOrder();
    }

    public GameResultCode recordMoving(FootrestLocation footrestLocation) {
        footPrint.record(footrestLocation);
        return GameResultCode.MOVE_SUCCESS;
    }

    public GameResultCode recordFail(FootrestLocation footrestLocation) {
        recordMoving(footrestLocation);
        isSuccess = false;
        tryCnt += 1;
        footPrint.failAtLast();
        return GameResultCode.FAIL;
    }

    public GameResultCode recordSuccess(FootrestLocation footrestLocation) {
        recordMoving(footrestLocation);
        isSuccess = true;
        tryCnt += 1;
        return GameResultCode.SUCCESS;
    }

    public void initResult() {
        footPrint = new FootPrint();
    }
}

package bridge.common;

import bridge.dto.MoveResultDto;

public class Result {
    private final Code code;
    private final MoveResultDto moveResult;
    private final int playCount;

    private Result(Code code, MoveResultDto moveResult, int playCount) {
        this.code = code;
        this.moveResult = moveResult;
        this.playCount = playCount;
    }

    public static Result createSuccessResult(MoveResultDto moveResult, int playCount) {
        return new Result(Code.SUCCESS, moveResult, playCount);
    }

    public static Result createFailureResult(MoveResultDto moveResult, int playCount) {
        return new Result(Code.FAILURE, moveResult, playCount);
    }

    public MoveResultDto getMoveResult() {
        return moveResult;
    }

    public Code getCode() {
        return code;
    }

    public int getPlayCount() {
        return playCount;
    }
}

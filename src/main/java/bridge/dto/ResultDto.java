package bridge.dto;

public class ResultDto {

    private int tryCount;

    private boolean isComplete;

    private CurrentPositionDto currentPositionDto;

    public ResultDto(int tryCount, boolean isComplete, CurrentPositionDto currentPositionDto) {
        this.tryCount = tryCount;
        this.isComplete = isComplete;
        this.currentPositionDto = currentPositionDto;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public CurrentPositionDto getCurrentPositionDto() {
        return currentPositionDto;
    }
}

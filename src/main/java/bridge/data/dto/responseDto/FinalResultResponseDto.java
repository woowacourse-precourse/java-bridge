package bridge.data.dto.responseDto;

public class FinalResultResponseDto{

    private final InGameCommandResponseDto gameResult;
    private final int tryCount;

    public FinalResultResponseDto(InGameCommandResponseDto gameResult, int tryCount) {
        this.gameResult = gameResult;
        this.tryCount = tryCount;
    }

    public InGameCommandResponseDto getGameResult() {
        return gameResult;
    }

    public int getTryCount() {
        return tryCount;
    }
}

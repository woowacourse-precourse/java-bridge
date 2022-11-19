package bridge.service.dto.response;

import bridge.domain.Result;

import java.util.List;

public class GameResultResponseDto {
    private final List<String> upSpaces;
    private final List<String> downSpaces;
    private final String gameSuccessOrFail;
    private final int totalTryNumber;

    public GameResultResponseDto(Result result) {
        this.upSpaces = result.getUpBlocks();
        this.downSpaces = result.getDownBlocks();
        this.gameSuccessOrFail = result.getGameOver().getName();
        this.totalTryNumber = result.getTotalTryNumber();
    }

    public List<String> getUpSpaces() {
        return upSpaces;
    }

    public List<String> getDownSpaces() {
        return downSpaces;
    }

    public String getGameSuccessOrFail() {
        return gameSuccessOrFail;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }
}

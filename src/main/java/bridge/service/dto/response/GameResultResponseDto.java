package bridge.service.dto.response;

import bridge.domain.Result;

import java.util.List;

public class GameResultResponseDto {
    private final List<String> upBlocks;
    private final List<String> downBlocks;
    private final String gameSuccessOrFail;
    private final int totalTryNumber;

    public GameResultResponseDto(Result result) {
        this.upBlocks = result.getUpBlocks();
        this.downBlocks = result.getDownBlocks();
        this.gameSuccessOrFail = result.getGameOver().getName();
        this.totalTryNumber = result.getTotalTryNumber() - 1;
    }

    public List<String> getUpBlocks() {
        return upBlocks;
    }

    public List<String> getDownBlocks() {
        return downBlocks;
    }

    public String getGameSuccessOrFail() {
        return gameSuccessOrFail;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }
}

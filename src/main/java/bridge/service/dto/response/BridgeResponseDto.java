package bridge.service.dto.response;

import bridge.domain.Result;

import java.util.List;

public class BridgeResponseDto {
    private final List<String> upBlocks;
    private final List<String> downBlocks;

    public BridgeResponseDto(Result result) {
        this.upBlocks = result.getUpBlocks();
        this.downBlocks = result.getDownBlocks();
    }

    public List<String> getUpBlocks() {
        return this.upBlocks;
    }

    public List<String> getDownBlocks() {
        return this.downBlocks;
    }
}

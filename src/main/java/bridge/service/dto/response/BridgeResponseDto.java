package bridge.service.dto.response;

import bridge.domain.Result;

import java.util.List;

public class BridgeResponseDto {
    private final List<String> upSpaces;
    private final List<String> downSpaces;

    public BridgeResponseDto(Result result) {
        this.upSpaces = result.getUpBlocks();
        this.downSpaces = result.getDownBlocks();
    }

    public List<String> getUpSpaces() {
        return this.upSpaces;
    }

    public List<String> getDownSpaces() {
        return this.downSpaces;
    }
}

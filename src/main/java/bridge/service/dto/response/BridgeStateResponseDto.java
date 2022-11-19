package bridge.service.dto.response;

import java.util.List;

public class BridgeStateResponseDto {
    private final List<String> upSpaces;
    private final List<String> downSpaces;

    public BridgeStateResponseDto(List<String> upSpaces, List<String> downSpaces) {
        this.upSpaces = upSpaces;
        this.downSpaces = downSpaces;
    }
}

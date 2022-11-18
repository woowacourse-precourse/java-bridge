package bridge.service.dto.response;

import java.util.List;

public class BridgeStateResponseDto {
    private final List<String> bridges;
    private final boolean goOrStop;

    public BridgeStateResponseDto(List<String> bridges, boolean goOrStop) {
        this.bridges = bridges;
        this.goOrStop = goOrStop;
    }
}

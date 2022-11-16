package bridge.service.dto;

public class BridgeSizeDto {
    private final String bridgeSize;

    public BridgeSizeDto(String bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public int toInt() {
        return Integer.parseInt(bridgeSize);
    }
}

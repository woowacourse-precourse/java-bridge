package bridge.service.dto.request;

import bridge.validator.BridgeSize;

public class BridgeSizeRequestDto {
    private final BridgeSize size;

    public BridgeSizeRequestDto(String size) {
        this.size = new BridgeSize(size);
    }

    public int getBridgeSize() {
        return size.getSize();
    }
}

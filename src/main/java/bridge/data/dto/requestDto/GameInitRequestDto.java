package bridge.data.dto.requestDto;

import static bridge.type.CommonConstantType.MAX_BRIDGE_SIZE;
import static bridge.type.CommonConstantType.MIN_BRIDGE_SIZE;
import static bridge.type.ErrorMessageDevType.BAD_BRIDGE_SIZE_MESSAGE;

public class GameInitRequestDto {

    private final int bridgeSize;

    public GameInitRequestDto(int bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private static void validateBridgeSize(int bridgeSize) {
        boolean isBridgeSizeOutOfRange = bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize;
        if (isBridgeSizeOutOfRange) {
            throw new IllegalStateException(String.format(BAD_BRIDGE_SIZE_MESSAGE.toString(), bridgeSize));
        }
    }

}

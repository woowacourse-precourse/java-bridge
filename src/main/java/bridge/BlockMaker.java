package bridge;

import static bridge.constant.BridgeMove.DOWN;
import static bridge.constant.BridgeMove.MISS;
import static bridge.constant.BridgeMove.UP;

public class BlockMaker {

    public String makeBlock(int bridgeNumber) {
        if (bridgeNumber == DOWN.getSymbolicNumber()) {
            return DOWN.getFirstLetter();
        }

        if (bridgeNumber == UP.getSymbolicNumber()) {
            return UP.getFirstLetter();
        }

        return MISS.getFirstLetter();
    }
}

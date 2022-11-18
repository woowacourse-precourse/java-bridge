package bridge;

import bridge.util.BridgeGameInfo;
import bridge.util.Message;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator =  new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @Test
    void bridgeDataTest()
    {
        List<String> bridgeData = bridgeMaker.makeBridge(100);

        for (String pixel : bridgeData) {
            validateBridgePixel(pixel);
        }
    }

    private void validateBridgePixel(String pixel)
    {
        if(pixel.equals(BridgeGameInfo.LOWER_MOVE) || pixel.equals(BridgeGameInfo.UPPER_MOVE))
            return;

        throw new IllegalArgumentException(Message.ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE);
    }
}

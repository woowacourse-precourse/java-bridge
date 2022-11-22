package bridge;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

    @Test
    void 다리_한_칸_데이터_생성_테스트() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeRandomNumberGenerator.generate();
        assertTrue(randomNumber == 0 || randomNumber == 1);
    }
}
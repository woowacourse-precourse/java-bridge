package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BridgeNumberGeneratorTest {


    @Test
    void 랜덤_변수_생성_테스트1() {
        //Null 값을 가지지는 않는지 Test
        BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        assertNotNull(bridgeNumberGenerator);
    }
}
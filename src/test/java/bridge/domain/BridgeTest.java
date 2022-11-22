package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {

    @DisplayName("다리 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 7, 13, 20})
    void makeBridgeTest(int bridgeSize) {
        Bridge bridge = new Bridge(bridgeSize);
        List<String> makeBridge = bridge.getBridge();

        long count = makeBridge.stream()
                .filter(up -> !up.equals("U"))
                .filter(down -> !down.equals("D"))
                .count();

        assertAll(
                () -> assertEquals(bridgeSize, makeBridge.size()),
                () -> assertEquals(0, count)
        );

    }

}
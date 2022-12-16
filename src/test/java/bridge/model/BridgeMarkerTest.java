package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.BridgeShapeInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMarkerTest {
    static BridgeMaker bridgeMaker;

    @BeforeAll
    static void setBridgeMarker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


    @DisplayName("임의의 값을 통해 다리 번호 확인")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void getBridgeShapeInfoTest(int bridgeNumber) {
        assertThat(BridgeShapeInfo.getBridgeShapeInfoWithNumber(bridgeNumber)).isNull();
    }

    @DisplayName("다리 모양의 예외처리")
    @Test
    void getBridgeShapeTest() {
        assertThatThrownBy(()->{
            bridgeMaker.notBridgeShape(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BridgeMaker를 통한 다리 생성")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6})
    void makeBridgeTest(int size) {
        List<String> bridgeShapes = Arrays.asList("U","D");
        assertThat(bridgeMaker.makeBridge(size)).allSatisfy(bridgeShape -> {
            assertThat(bridgeShapes).contains(bridgeShape);
        });
    }
}

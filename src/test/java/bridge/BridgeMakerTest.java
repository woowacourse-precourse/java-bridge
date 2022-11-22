package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("매개변수에 맞게 다리의 길이가 잘 생성되었는지 테스트.")
    @ValueSource(ints = {5, 10, 19})
    @ParameterizedTest
    void bridgeSizeTest(int size) {
        assertThat(bridgeMaker.makeBridge(size).size())
                .isEqualTo(size);
    }

    @DisplayName("다리 모양이 U또는 D로 생성 되었는지 테스트.")
    @Test
    void bridgeShapeTest() {
        assertThat(List.of("U", "D")).contains(bridgeMaker.getBridgeShape());
    }
}
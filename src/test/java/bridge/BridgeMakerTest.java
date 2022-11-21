package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("0/1로 들어온 다리를 U/D로 변환하여 저장 성공")
    @Test
    void testMakeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridgeList = bridgeMaker.makeBridge(6);

        assertThat(bridgeList).allMatch(bridge -> Set.of("U", "D")
                .contains(bridge));
    }

    @DisplayName("다리의 길이가 3 이상 20 이하가 아니면 실패")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void testBridgeRange(int size) {
        // given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bridgeMaker.makeBridge(size));
    }
}

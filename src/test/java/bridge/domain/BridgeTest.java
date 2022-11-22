package bridge.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeTest {

    List<String> bridgeMap = List.of("U", "U", "U", "U", "U", "U");
    Bridge bridge = new Bridge(bridgeMap);

    @DisplayName("생성된 다리 길이는 지정된 길이와 같다.")
    @Test
    void 다리_길이는_지정된_길이() {
        assertThat(bridge)
                .extracting("bridge", InstanceOfAssertFactories.LIST)
                .hasSize(bridgeMap.size());
    }

    @DisplayName("다리를 이동할 수 있는지 판달할 수 있다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동_가능_판단(String spaceToMove) {
        assertThat(bridge.hasNextTileThatPosition(0, spaceToMove)).isEqualTo(bridgeMap.get(0).equals(spaceToMove));
    }
}
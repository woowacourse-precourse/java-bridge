package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeMakerTest {

    @DisplayName("원하는 개수만큼 다리의 길이가 생성되는지 확인한다.")
    @ValueSource(strings = {"2", "3", "10", "20"})
    @ParameterizedTest
    void makeBridge(Integer input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(input);
        assertThat(list.size()).isEqualTo(input);
        assertThat(list).containsAnyOf("U", "D");
    }
}
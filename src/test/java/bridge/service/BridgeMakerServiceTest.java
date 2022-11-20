package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerServiceTest {

    @ParameterizedTest
    @ValueSource (ints = {20,3,11})
    void 다리_생성_기능_테스트(int size) {
        assertThat(BridgeMakerService.createBridge(size))
                .isInstanceOf(Bridge.class);
    }

    @ParameterizedTest
    @ValueSource (ints = {1,25})
    void 다리_길이_범위_초과_에러_테스트(int size) {
        assertThatThrownBy(() -> BridgeMakerService.createBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
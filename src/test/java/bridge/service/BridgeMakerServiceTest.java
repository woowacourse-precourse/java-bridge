package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerServiceTest {

    @DisplayName("다리 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource (ints = {20,3,11})
    void 다리_생성_기능_테스트(int size) {
        assertThat(BridgeMakerService.createBridge(size))
                .isInstanceOf(Bridge.class);
    }

    @DisplayName("다리 길이가 범위 밖일 때는 에러가 발생합니다.")
    @ParameterizedTest
    @ValueSource (ints = {1,25})
    void 다리_길이_범위_초과_에러_테스트(int size) {
        assertThatThrownBy(() -> BridgeMakerService.createBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {
    private final Bridge testBridge = new Bridge(List.of("U","D","U"));

    @DisplayName("정확한 길이가 반환되는 지 테스트 한다.")
    @Test
    void bridgeSizeTest() {
        assertThat(testBridge.size()).isEqualTo(3);
    }

    @DisplayName("특정 위치로 이동 가능할때 참을 반환하는지 테스트한다.")
    @ValueSource(strings = {"U,0","D,1","U,2"})
    @ParameterizedTest
    void bridgeMovableTest(String input) {
        String[] inputs = input.split(",");
        assertThat(testBridge.isMovable(inputs[0],Integer.parseInt(inputs[1]))).isTrue();
    }

    @DisplayName("특정 위치로 이동 불가능할때 거짓을 반환하는지 테스트한다.")
    @ValueSource(strings = {"D,0","U,1","D,2"})
    @ParameterizedTest
    void bridgeNotMovableTest(String input) {
        String[] inputs = input.split(",");
        assertThat(testBridge.isMovable(inputs[0],Integer.parseInt(inputs[1]))).isFalse();
    }

    @DisplayName("3부터 20 사이가 아닌 길이로 다리를 생성할 경우 예외가 발생한다.")
    @Test
    void bridgeValidSizeTest() {
        assertThatThrownBy(() -> new Bridge(List.of("U","U")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 혹은 D가 아닌 원소로 다리를 생성할 경우 예외가 발생한다.")
    @Test
    void bridgeValidElementTest() {
        assertThatThrownBy(() -> new Bridge(List.of("a","b","c","d")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

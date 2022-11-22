package bridge.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("다리 도메인 로직 테스트")
public class BridgeTest {

    @DisplayName("다리가 제대로 생성 되는지 확인한다.")
    @Test
    void checkBridgeGeneration() {
        Bridge bridge= new Bridge(List.of("U", "U", "D"));
        assertThat(bridge).isNotNull();
    }

    @DisplayName("다리 길이가 정확히 반환되는지 검사한다.")
    @ParameterizedTest
    @MethodSource("BridgeData")
    void checkBridgeGetSize(Bridge bridge, int expectedSize) {
        assertThat(bridge.getSize()).isEqualTo(expectedSize);
    }

    static Stream<Arguments> BridgeData() {
        return Stream.of(
                Arguments.of(new Bridge(List.of("U","U","U")), 3),
                Arguments.of(new Bridge(List.of("U","U","U","D","D","U","D")), 7),
                Arguments.of(new Bridge(List.of("U","U","U","D","D","D","D","D","D","U","D")), 11),
                Arguments.of(new Bridge(List.of("U","D","D","D","U")), 5),
                Arguments.of(new Bridge(List.of("D","U","U","U","U","D","D","D","D","U")), 10)
        );
    }
}

package bridge.domain.oxbridgebuilder;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UDBridgeTest {

    UDBridge udBridge;

    @BeforeEach
    void setUdBridge() {
        udBridge = UDBridge.of();
    }

    @DisplayName("udBridge에 OX가 잘 추가되는지 확인하는 테스트")
    @MethodSource("addTestArgumentProvider")
    @ParameterizedTest
    void addTest(String OX, String result) {
        udBridge.add(OX);
        Assertions.assertThat(udBridge.toString()).isEqualTo(result);
    }

    private static Stream<Arguments> addTestArgumentProvider() {
        return Stream.of(
            Arguments.of("O", "[ O ]\n"),
            Arguments.of("O", "[ O ]\n"),
            Arguments.of("X", "[ X ]\n")
        );
    }
}
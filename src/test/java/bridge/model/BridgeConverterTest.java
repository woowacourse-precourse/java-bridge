package bridge.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeConverterTest {

    static final String UP = "U";
    static final String DOWN = "D";

    @DisplayName("1과 0으로 이루어진 다리를 U와 D로 이루어진 다리로 변환한다")
    @ParameterizedTest
    @MethodSource("generateData")
    void convert(List<Integer> numberBridge, List<String> convertedBridge) {
        BridgeConverter bridgeConverter = new BridgeConverter();

        List<String> result = bridgeConverter.convert(numberBridge);

        assertThat(result).isEqualTo(convertedBridge);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 1), List.of(UP, UP, UP)),
                Arguments.of(List.of(0, 0, 0, 0), List.of(DOWN, DOWN, DOWN, DOWN)),
                Arguments.of(List.of(1, 0, 1, 0, 1, 0), List.of(UP, DOWN, UP, DOWN, UP, DOWN))
        );
    }
}
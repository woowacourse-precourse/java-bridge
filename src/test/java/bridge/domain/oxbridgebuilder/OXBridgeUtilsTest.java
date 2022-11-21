package bridge.domain.oxbridgebuilder;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OXBridgeUtilsTest {

    @DisplayName("OX가 잘 반환되는지 테스트")
    @MethodSource("makerOXTestArgumentProvider")
    @ParameterizedTest
    void makeOXTest(boolean trueOfFalse, String expectedOX) {
        Assertions.assertThat(OXBridgeUtils.makeOX(trueOfFalse)).isEqualTo(expectedOX);
    }

    private static Stream<Arguments> makerOXTestArgumentProvider() {
        return Stream.of(
            Arguments.of(true, "O"),
            Arguments.of(false, "X")
        );
    }
}
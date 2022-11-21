package bridge.domain.resources.bridge;

import static bridge.domain.resources.bridge.BridgeSize.from;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @Nested
    @DisplayName("Bridge Class")
    class BridgeKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for right input of")
        class DescribeValidationRightInput {

            @DisplayName("inside the boundaries")
            @ParameterizedTest(name = "{0}")
            @MethodSource("validParameters")
            void InsideTheBoundaries(String input, int sizeOfBridge) {

                BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
                BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
                BridgeSize bridgeSize = from(sizeOfBridge);
                List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());

                assertThat(
                bridge.stream()
                    .filter(c-> c.equals("U") || c.equals("D"))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new))
                    .isNotInstanceOf(IllegalArgumentException.class);

            }

            Stream<Arguments> validParameters() {
                return Stream.of(
                    Arguments.of("3", 3),
                    Arguments.of("4", 4),
                    Arguments.of("5", 5),
                    Arguments.of("6", 6),
                    Arguments.of("7", 7),
                    Arguments.of("8", 8),
                    Arguments.of("9", 9),
                    Arguments.of("10", 10),
                    Arguments.of("11", 11),
                    Arguments.of("12", 12),
                    Arguments.of("13", 13),
                    Arguments.of("14", 14),
                    Arguments.of("15", 15),
                    Arguments.of("16", 16),
                    Arguments.of("17", 17),
                    Arguments.of("18", 18),
                    Arguments.of("19", 19),
                    Arguments.of("20", 20)
                );
            }
        }
    }
}

package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BridgeTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isPartOfBridge 메소드 테스트")
    class IsPartOfBridge {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 한_다리가_다른_다리의_일부분인지_체크하는_기능을_테스트(Bridge source, Bridge target) {
            assertThat(source.isPartOfBridge(target)).isTrue();
        }


        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Bridge(List.of()), new Bridge(List.of())),
                    Arguments.of(new Bridge(List.of("U")), new Bridge(List.of("U"))),
                    Arguments.of(new Bridge(List.of("U", "D")), new Bridge(List.of("U", "D", "D"))),
                    Arguments.of(new Bridge(List.of("U")), new Bridge(List.of("U", "D", "D"))),
                    Arguments.of(new Bridge(List.of("U", "D", "D", "D")), new Bridge(List.of("U", "D", "D", "D")))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("containsAll 메소드 테스트")
    class ContainsAll {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 한_다리가_다른_리스트의_값을_포함하는지_체크하는_기능을_테스트(Bridge source, List<String> target) {
            assertThat(source.containsAll(target)).isTrue();
        }


        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Bridge(List.of()), List.of()),
                    Arguments.of(new Bridge(List.of("U")), List.of("U")),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), List.of("U", "D")),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), List.of("U")),
                    Arguments.of(new Bridge(List.of("U", "D", "D", "D")), List.of("U", "D", "D", "D"))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("toString 메소드 테스트")
    class ToString {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 브리지_정보가_스트링으로_변환되는_기능을_테스트(Bridge source, String target) {
            assertThat(source.toString()).isEqualTo(target);
        }


        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Bridge(List.of()), "[]"),
                    Arguments.of(new Bridge(List.of("U")), "[U]"),
                    Arguments.of(new Bridge(List.of("U", "D")), "[U, D]"),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), "[U, D, D]"),
                    Arguments.of(new Bridge(List.of("U", "D", "D", "D")), "[U, D, D, D]")
            );
        }
    }
}
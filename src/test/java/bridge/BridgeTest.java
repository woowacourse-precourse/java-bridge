package bridge;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("isSame 메소드 테스트")
    class IsSame {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 두_다리가_같은_값인지_체크하는_기능을_테스트(Bridge source, Bridge target) {
            assertThat(source.isSame(target)).isTrue();
        }


        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Bridge(List.of()), new Bridge(List.of())),
                    Arguments.of(new Bridge(List.of("U")), new Bridge(List.of("U"))),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), new Bridge(List.of("U", "D", "D"))),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), new Bridge(List.of("U", "D", "D"))),
                    Arguments.of(new Bridge(List.of("U", "D", "D", "D")), new Bridge(List.of("U", "D", "D", "D")))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isSameValue 메소드 테스트")
    class IsSameValue {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 다리가_리스트와_같은_값인지_체크하는_기능을_테스트(Bridge source, List<String> target) {
            assertThat(source.isSameValue(target)).isTrue();
        }


        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(new Bridge(List.of()), List.of()),
                    Arguments.of(new Bridge(List.of("U")), List.of("U")),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), List.of("U", "D", "D")),
                    Arguments.of(new Bridge(List.of("U", "D", "D")), List.of("U", "D", "D")),
                    Arguments.of(new Bridge(List.of("U", "D", "D", "D")), List.of("U", "D", "D", "D"))
            );
        }
    }
}
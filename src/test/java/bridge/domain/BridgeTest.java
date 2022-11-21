package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class BridgeTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("도메인 로직 예외처리 테스트")
    class DomainException {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 브리지를_생성할때_유효한_값이_아니면_예외처리_하는지_테스트(List<String> target) {
            assertThatThrownBy(() -> new Bridge(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.BRIDGE_ELEMENT_INVALID);
        }

        @ParameterizedTest
        @ValueSource(strings = {"u", "d", "", " ", "\n", "!", "UU", "DD"})
        void 움직임_값이_U혹은_D가_아니라면_예외처리_하는지_테스트(String target) {
            Bridge bridge = new Bridge(new ArrayList<>());
            assertThatThrownBy(() -> bridge.addBlock(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.BRIDGE_ELEMENT_INVALID);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of("U", "u")),
                    Arguments.of(List.of("1", "2", "3")),
                    Arguments.of(List.of("D", "u", "D")),
                    Arguments.of(List.of("d", "D", "#")),
                    Arguments.of(List.of("U", "u", " "))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("isPartOfBridgeInOrder 메소드 테스트")
    class IsPartOfBridgeInOrder {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 한_브리지가_순서대로_다른_브리지의_일부분인지_체크하는_기능을_테스트(Bridge source, Bridge target) {
            assertThat(source.isPartOfBridgeInOrder(target)).isTrue();
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
    @DisplayName("containsAllInOrder 메소드 테스트")
    class ContainsAllInOrder {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 한_브리지가_다른_리스트의_값을_포함하는지_체크하는_기능을_테스트(Bridge source, List<String> target) {
            assertThat(source.containsAllInOrder(target)).isTrue();
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
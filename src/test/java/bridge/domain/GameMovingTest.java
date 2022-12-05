package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameMovingTest {
    @Nested
    @DisplayName("getMovingFromNumber 메소드 테스트")
    class GetMovingFromNumber {
        @ParameterizedTest
        @CsvSource(value = {"0, D", "1, U"})
        void 숫자를_입력받으면_매핑된_메세지를_잘_반환하는지_테스트(int number, String expected) {
            assertThat(GameMoving.getMovingFromNumber(number)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("isDown 메소드 테스트")
    class IsDown {
        @ParameterizedTest
        @ValueSource(strings = {"D"})
        void D가_들어오면_참을_반환하는지_테스트(String target) {
            assertThat(GameMoving.isDown(target)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {"A, B, C, E, a, 1, #, U"})
        void D가_아닌_값은_거짓을_반환하는지_테스트(String target) {
            assertThat(GameMoving.isDown(target)).isFalse();
        }
    }

    @Nested
    @DisplayName("isUp 메소드 테스트")
    class IsUp {
        @ParameterizedTest
        @ValueSource(strings = {"U"})
        void U가_들어오면_참을_반환하는지_테스트(String target) {
            assertThat(GameMoving.isUp(target)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {"A, B, C, E, a, 1, #, D"})
        void U가_아닌_값은_거짓을_반환하는지_테스트(String target) {
            assertThat(GameMoving.isUp(target)).isFalse();
        }
    }
}
package bridge;

import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Nested
    @DisplayName("다리 길이가")
    class SizeRangeTest {

        @DisplayName("20 초과시 예외를 반환한다.")
        @Test
        void test1() {
            assertThatThrownBy(() -> validator.validateBridgeSize(MAX_SIZE + 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3 미만시 예외를 반환한다.")
        @Test
        void test2() {
            assertThatThrownBy(() -> validator.validateBridgeSize(MIN_SIZE - 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3 이상, 20 이하일시 BirdgeSize를 정상적으로 생성한다")
        @ValueSource(ints = {MIN_SIZE, MAX_SIZE})
        @ParameterizedTest
        void test3(int size) {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateBridgeSize(size));
        }
    }

}
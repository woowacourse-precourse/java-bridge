package bridge.domain;

import static bridge.domain.BridgeSize.MAX_SIZE;
import static bridge.domain.BridgeSize.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @Nested
    @DisplayName("다리 길이가")
    class test {

        @DisplayName(MAX_SIZE  + " 초과시 예외를 반환한다.")
        @Test
        void test1() {
            assertThatThrownBy(() -> new BridgeSize(MAX_SIZE + 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName(MIN_SIZE + " 미만시 예외를 반환한다.")
        @Test
        void test2() {
            assertThatThrownBy(() -> new BridgeSize(MIN_SIZE -1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3 이상, 20 이하일시 BirdgeSize를 정상적으로 생성한다")
        @ValueSource(ints = {MIN_SIZE, MAX_SIZE})
        @ParameterizedTest
        void test3(int size) {
            assertThatNoException()
                    .isThrownBy(() -> new BridgeSize(size));
        }
    }

}
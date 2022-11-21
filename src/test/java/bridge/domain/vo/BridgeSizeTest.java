package bridge.domain.vo;

import static bridge.domain.vo.BridgeSize.MAX_SIZE;
import static bridge.domain.vo.BridgeSize.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @Nested
    @DisplayName("다리 길이가")
    class CreateBridgeSize {

        @DisplayName(MIN_SIZE + " 미만," + MAX_SIZE + " 초과일시 예외를 반환한다.")
        @ValueSource(ints = {MIN_SIZE - 1, MAX_SIZE + 1})
        @ParameterizedTest

        void When_InputWrongRangeValue_Expect_Exception(int wrongValue) {
            assertThatThrownBy(() -> new BridgeSize(wrongValue))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName(MIN_SIZE + " 이상," + MAX_SIZE + " 이하일시 BirdgeSize를 정상적으로 생성한다")
        @ValueSource(ints = {MIN_SIZE, MAX_SIZE})
        @ParameterizedTest
        void When_InputRightRangeValue_Expect_CreateInstance(int rightValue) {
            assertThatNoException().isThrownBy(() -> new BridgeSize(rightValue));
        }
    }

}
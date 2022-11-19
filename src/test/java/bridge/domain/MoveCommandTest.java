package bridge.domain;

import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCommandTest {

    @DisplayName("이동 명령 메시지가")
    @Nested
    class test {

        @DisplayName(UPPER_BLOCK +", " + LOWER_BLOCK + "일시 정상적으로 생성한다")
        @ValueSource(strings = {UPPER_BLOCK, LOWER_BLOCK})
        @ParameterizedTest
        void test1(String input) {
            assertThatNoException()
                    .isThrownBy(() -> new MoveCommand(input));
        }


        @DisplayName(UPPER_BLOCK + "," + LOWER_BLOCK + "가 아니라면 예외를 반환한다.")
        @Test
        void test3() {
            assertThatThrownBy(() -> new MoveCommand("wrongValue"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
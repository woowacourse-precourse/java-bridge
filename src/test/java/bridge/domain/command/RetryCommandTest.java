package bridge.domain.command;

import static bridge.constant.BridgeConstant.CLOSE_GAME;
import static bridge.constant.BridgeConstant.RESTART_GAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryCommandTest {

    @Nested
    @DisplayName("게임 재시작 여부 메시지가")
    class test {


        @DisplayName(RESTART_GAME +", " + CLOSE_GAME + "일시 정상적으로 생성한다")
        @ValueSource(strings = {RESTART_GAME, CLOSE_GAME})
        @ParameterizedTest
        void test1(String input) {
            assertThatNoException()
                    .isThrownBy(() -> new RetryCommand(input));
        }


        @DisplayName(RESTART_GAME + "," + CLOSE_GAME + "가 아니라면 예외를 반환한다.")
        @Test
        void test3() {
            assertThatThrownBy(() -> new RetryCommand("wrongValue"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("내부 메시지가")
    @Nested
    class test2 {

        @DisplayName(RESTART_GAME + "일시 true를 반환한다.")
        @Test
        void test1() {
            assertThat(new RetryCommand(RESTART_GAME).isRetry()).isTrue();
        }

        @DisplayName(CLOSE_GAME + "일시 false 반환한다.")
        @Test
        void test2() {
            assertThat(new RetryCommand(CLOSE_GAME).isRetry()).isFalse();
        }
    }
}
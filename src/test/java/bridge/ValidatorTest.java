package bridge;

import static bridge.constant.BridgeConstant.CLOSE_GAME;
import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static bridge.constant.BridgeConstant.RESTART_GAME;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;
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

    @Nested
    @DisplayName("이동 명령 메시지가")
    class MoveMessageTest {

        @DisplayName(UPPER_BLOCK + " 일시 정상 통과한다")
        @Test
        void test1() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateMoveMessage(UPPER_BLOCK));
        }

        @DisplayName(LOWER_BLOCK + " 일시 정상 통과한다")
        @Test
        void test2() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateMoveMessage(LOWER_BLOCK));
        }

        @DisplayName(UPPER_BLOCK + "," + LOWER_BLOCK + "가 아니라면 예외를 반환한다.")
        @Test
        void test3() {
            assertThatThrownBy(() -> validator.validateMoveMessage(UPPER_BLOCK + LOWER_BLOCK))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("게임 재시작 여부 메시지가")
    class GameRestartMessageTest {

        @DisplayName(RESTART_GAME + " 일시 정상 통과한다")
        @Test
        void test1() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateGameRestartMessage(RESTART_GAME));
        }

        @DisplayName(CLOSE_GAME + " 일시 정상 통과한다")
        @Test
        void test2() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateGameRestartMessage(CLOSE_GAME));
        }

        @DisplayName(RESTART_GAME + "," + CLOSE_GAME + "가 아니라면 예외를 반환한다.")
        @Test
        void test3() {
            assertThatThrownBy(() -> validator.validateGameRestartMessage(RESTART_GAME + CLOSE_GAME))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
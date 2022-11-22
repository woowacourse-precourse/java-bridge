package bridge.util;

import bridge.constant.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.BridgeMove.DOWN;
import static bridge.constant.BridgeMove.UP;
import static bridge.constant.BridgeRange.MAX_LENGTH;
import static bridge.constant.BridgeRange.MIN_LENGTH;
import static bridge.constant.message.ExceptionMessage.BRIDGE_LENGTH_RANGE;
import static bridge.constant.message.ExceptionMessage.PLAYER_MOVE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest {

    @DisplayName("다리 길이로 잘못된 타입이 들어왔을 때 예외를 터트려야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3a", "a33", "abc", "@#$#("})
    void 다리_길이_타입_검증_테스트(String input) {
        //given
        ValidationUtil validationUtil = new ValidationUtil();

        //when, then
        assertThatThrownBy(() ->
                validationUtil.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BRIDGE_LENGTH_TYPE.getMessage());
    }

    @DisplayName("잘못된 범위의 값이 들어왔을 때 예외를 터트려야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"21", "2", "100"})
    void 다리_길이_범위_검증_테스트(String input) {
        //given
        ValidationUtil validationUtil = new ValidationUtil();

        //when, then
        assertThatThrownBy(() ->
                validationUtil.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BRIDGE_LENGTH_RANGE.getMessage(),
                        MIN_LENGTH.getNumber(), MAX_LENGTH.getNumber()));
    }

    @DisplayName("다리 길이로 3~20 사이의 숫자값이 들어오면 통과해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "15", "8"})
    void 다리_길이_올바른_값_검증_테스트(String input) {
        //given
        ValidationUtil validationUtil = new ValidationUtil();

        //when, then
        assertThatCode(() ->
                        validationUtil.validateBridgeLength(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸으로 U 혹은 D가 들어오면 통과해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 이동할_칸_올바른_값_검증_테스트(String input) {
        // given
        ValidationUtil validationUtil = new ValidationUtil();

        // when, then
        assertThatCode(() ->
                validationUtil.validatePlayerMoveInput(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동할 칸으로 U, D가 아닌 다른 값이 들어오면 오류가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"29384", "A", "UU", "UD", "(@#$"})
    void 이동할_칸_잘못된_값_검증_테스트(String input) {
        // given
        ValidationUtil validationUtil = new ValidationUtil();

        // when, then
        assertThatThrownBy(() ->
                validationUtil.validatePlayerMoveInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(PLAYER_MOVE.getMessage(),
                        UP.getIdentifier(), DOWN.getIdentifier()));
    }

}


package bridge.util;

import bridge.constant.message.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.BridgeRange.MAX_LENGTH;
import static bridge.constant.BridgeRange.MIN_LENGTH;
import static bridge.constant.message.ExceptionMessage.BRIDGE_LENGTH_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest {

    @DisplayName("다리 길이로 잘못된 타입이 들어왔을 때 예외를 터트려야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3a", "a33", "abc", "@#$#("})
    void 다리_길이_타입_검증_테스트(String input) throws Exception {
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
    void 다리_길이_범위_검증_테스트(String input) throws Exception {
        //given
        ValidationUtil validationUtil = new ValidationUtil();
        //when, then
        assertThatThrownBy(() ->
                validationUtil.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BRIDGE_LENGTH_RANGE.getMessage(),
                        MIN_LENGTH.getNumber(), MAX_LENGTH.getNumber()));
    }
}


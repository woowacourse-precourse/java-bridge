package bridge.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgePositionParserTest {

    @DisplayName("다리 생성 중 랜덤 숫자가 잘못된 경우 오류 반환")
    @ValueSource(ints = {3, 4, -1})
    @ParameterizedTest
    void throwErrorWhenRandomNumberIsInvalid(int randomNumber) {
        Assertions.assertThatThrownBy(() ->
                BridgePositionParser.parsePositionToStringForm(randomNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 숫자가 올바르면 그에 맞는 문자열을 반환한다")
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    @ParameterizedTest
    void returnStringWhenRandomNumberIsValid(int randomNumber, String position) {
        assertThat(BridgePositionParser.parsePositionToStringForm(randomNumber)).isEqualTo(position);
    }
}
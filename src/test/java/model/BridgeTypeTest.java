package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTypeTest {

    @DisplayName("다리 숫자 전달 시 문자열 반환")
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    @ParameterizedTest(name = "[{index}]  {0} 전달 시 {1} 반환")
    void getMarkByNumber(Integer number, String mark) {
        String type = BridgeType.getStringByNumber(number);

        assertEquals(type, mark);
    }

    @DisplayName("잘못된 숫자 전달 시 오류 반환")
    @ValueSource(strings = {"-1", "2"})
    @ParameterizedTest(name = "[{index}]  {0} 전달 시 오류 반환")
    void getMarkByWrongNumber(Integer number) {
        assertThatThrownBy(() ->
                BridgeType.getStringByNumber(number)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 또는 0이 아닙니다.");
    }
}
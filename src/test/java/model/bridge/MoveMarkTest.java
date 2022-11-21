package model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveMarkTest {

    @DisplayName("이동할 칸이 U 또는 D가 아닐 때 예외 처리")
    @ValueSource(strings = {"T", "V", "C", "E"})
    @ParameterizedTest(name = "[{index}]  mark : {0}")
    void excessSize(String mark) {
        assertThatThrownBy(() ->
                new MoveMark(mark)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
    }

    @DisplayName("이동할 칸이 U 또는 D일 때 통과")
    @ValueSource(strings = {"U", "D", "u", "d", "U ", " D", " u", "d "})
    @ParameterizedTest(name = "[{index}]  mark : [{0}]")
    void correctSize(String mark) {
        assertThatCode(() ->
                new MoveMark(mark)
        ).doesNotThrowAnyException();
    }
}
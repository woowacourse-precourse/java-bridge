package model.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeTest {

    @DisplayName("다리 길이가 3보다 작을 때 예외 처리")
    @ValueSource(strings = {"2", "-1", "0"})
    @ParameterizedTest(name = "[{index}]  size : {0}")
    void underSize(Integer size) {
        assertThatThrownBy(() ->
                new BridgeSize(size)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이여야 합니다.");
    }

    @DisplayName("다리 길이가 20보다 클 때 예외 처리")
    @ValueSource(strings = {"21", "1000"})
    @ParameterizedTest(name = "[{index}]  size : {0}")
    void excessSize(Integer size) {
        assertThatThrownBy(() ->
                new BridgeSize(size)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이여야 합니다.");
    }

    @DisplayName("다리 길이가 3~20 범위일 때 통과")
    @ValueSource(strings = {"3", "5", "15", "20"})
    @ParameterizedTest(name = "[{index}]  size : {0}")
    void correctSize(Integer size) {
        assertThatCode(() ->
                new BridgeSize(size)
        ).doesNotThrowAnyException();
    }
}
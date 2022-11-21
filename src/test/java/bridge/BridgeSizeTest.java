package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeSizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "a", "ㄱ", "?", "."})
    void 다리_길이의_값이_숫자가_아닌_문자일_경우_예외_발생(String wrongLetter) {
        //then
        Assertions.assertThatThrownBy(() -> {
            new BridgeSize(wrongLetter);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이의_첫_번째_시작값이_1부터_9까지가_아닐_경우_예외_발생() {
        //then
        Assertions.assertThatThrownBy(() -> {
            new BridgeSize("012");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    void 다리_길이가_3에서_20을_벗어날_경우_예외_발생(String outOfRangeNumber) {
        //then
        Assertions.assertThatThrownBy(() -> {
            new BridgeSize(outOfRangeNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
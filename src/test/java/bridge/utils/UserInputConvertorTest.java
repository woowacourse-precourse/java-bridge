package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class UserInputConvertorTest {
    @DisplayName("다리 길이는 숫자여야 한다.")
    @Test
    void 다리_길이는_숫자() {
        assertThatThrownBy(() -> UserInputConvertor.mapToBridgeLength("C"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이는 3이상 20이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    void 다리_길이는_3이상_20이하(String bridgeLength) {
        assertThatThrownBy(() -> UserInputConvertor.mapToBridgeLength(bridgeLength))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
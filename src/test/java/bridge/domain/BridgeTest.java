package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("범위을 벗어난 값으로 다리를 생성하면 예외가 발생한다.")
    @ValueSource(ints = {1, 2, 21, 2000})
    @ParameterizedTest
    void outRangeInputNum(int bridgeSize) {
        assertThatThrownBy(() -> new Bridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력값에 맞게 다리 길이가 제대로 생성되었는지 테스트")
    @ValueSource(ints = {3, 13, 15, 20})
    @ParameterizedTest
    void createShapeSizeTest(int bridgeSize) {
        assertThat(new Bridge(bridgeSize).getShape().size())
                .isEqualTo(bridgeSize);
    }

    @DisplayName("다리 모양이 U또는 D로 생성 되었는지 테스트.")
    @Test
    void bridgeShapeTest() {
        Bridge bridge = new Bridge(20);
        for (String str : bridge.getShape()) {
            assertThat(List.of("U", "D")).contains(str);
        }
    }
}
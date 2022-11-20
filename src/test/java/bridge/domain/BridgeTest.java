package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U", "D", "D"), 3);
    }

    @DisplayName("다리 길이가 3부터 20 사이여야 한다.")
    @Test
    void validateBridgeSize() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D"), 2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bridge(List.of("U", "D", "U", "D", "U", "D", "U", "D",
                "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U"), 21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 칸이 이동 가능한지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:U", "1:D", "2:D"}, delimiter = ':')
    void checkToMoveTest(int position, String moveTo) {
        assertTrue(bridge.checkToMove(position, moveTo));
    }
}
package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    public static final Bridge UPPER_BRIDGE = new Bridge(() -> 1, 2);
    public static final Bridge LOWER_BRIDGE = new Bridge(() -> 0, 2);
    
    @Test
    @DisplayName("다리 길이와 현재 포지션이 같은지 확인")
    void isGameFinished() {
        assertThat(UPPER_BRIDGE.isSameWithBridgeSize(2)).isTrue();
    }
    
    @DisplayName("해당 포지션에 칸이 존재하는지 확인")
    @ParameterizedTest(name = "{displayName} : position => {0}")
    @ValueSource(ints = {0, 1})
    void isPartBridgeExist(final int position) {
        assertThat(UPPER_BRIDGE.isPartBridgeExist(position, "U")).isTrue();
    }
}
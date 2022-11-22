package domain;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("초기_다리_생성_성공")
    @ValueSource(ints = {5, 15, 20})
    @ParameterizedTest
    public void 다리_생성_성공(int size) {
        Bridge bridge = new Bridge(size);
        assertThat(bridge.getBridge().size()).isEqualTo(size);
    }

    @DisplayName("다리가 U, D로만 이루어져있으면 성공")
    @Test
    public void 오직_U_D_성공() {
        // given
        Bridge bridge = new Bridge(20);
        // when
        List<String> testBridge = bridge.getBridge().stream().filter(s -> (s.equals("U") || s.equals("D")))
                .collect(Collectors.toList());
        //then
        assertThat(testBridge).isEqualTo(bridge.getBridge());
    }
}

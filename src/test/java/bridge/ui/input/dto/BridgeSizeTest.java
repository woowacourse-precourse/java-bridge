package bridge.ui.input.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "21", "1a", "", " ", "1.0", "12.4"})
    public void 다리_길이는_3에서_20사이의_자연수만_가능하다(String input) {
        Assertions.assertThatThrownBy(() ->
                        BridgeSize.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "1", "20", "10", "15"})
    public void 다리_길이는_생성_테스트(String input) {
        BridgeSize bridgeSize = BridgeSize.from(input);
        Assertions.assertThat(bridgeSize).isEqualTo(Integer.parseInt(input));
    }


}
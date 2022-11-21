package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @DisplayName("다리가 생성된다.")
    @Test
    void makeBridge() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when
        List<String> bridge = bridgeMaker.makeBridge(10);

        //then
        assertThat(bridge.size()).isEqualTo(10);
        for (String command : bridge) {
            assertThat(Pattern.matches("^[UD]$", command)).isTrue();
        }
    }

    @DisplayName("지정된 다리 크기에 벗어나면 예외가 발생한다.")
    @Test
    void makeBridgeFail() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when

        //then
        Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
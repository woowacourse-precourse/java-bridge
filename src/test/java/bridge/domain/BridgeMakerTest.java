package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.generator.BridgeMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @BeforeAll
    static void setUpBridgeMaker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리가 생성된다.")
    @Test
    void makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(10);

        assertThat(bridge.size()).isEqualTo(10);
        for (String command : bridge) {
            assertThat(Pattern.matches("^[UD]$", command)).isTrue();
        }
    }

    @DisplayName("지정된 다리 크기에 벗어나면 예외가 발생한다.")
    @ValueSource(strings = {"21", "2", "101"})
//    @ParameterizedTest
    void makeBridgeFail(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
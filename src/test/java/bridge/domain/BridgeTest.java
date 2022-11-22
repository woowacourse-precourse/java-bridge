package bridge.domain;

import static bridge.config.ExceptionMessage.ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("정답 다리와 유저 입력 다리 테스트")
    @Test
    void compareCorrectBridgesTest() {
        Bridge answerBridge = new Bridge(List.of("U", "D", "U", "U", "D"));
        Bridge userBridge = new Bridge(List.of("U", "D", "U"));
        boolean answer = true;
        assertThat(answer).isEqualTo(answerBridge.isPassableBridge(userBridge));
    }

    @DisplayName("틀린 다리와 유저 입력 다리 테스트")
    @Test
    void compareWrongBridgesTest() {
        Bridge answerBridge = new Bridge(List.of("U", "D", "U", "U", "D"));
        Bridge userBridge = new Bridge(List.of("U", "D", "D"));
        boolean answer = false;
        assertThat(answer).isEqualTo(answerBridge.isPassableBridge(userBridge));
    }

    @DisplayName("다리의 요소중에 U와 D가 아니면 예외가 발생한다.")
    @Test
    void insertSquaresWithWrongElement() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "D", "A", "D")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}

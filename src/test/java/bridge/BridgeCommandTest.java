package bridge;

import bridge.domain.Command;
import bridge.domain.bridge.BridgeCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeCommandTest {

    @DisplayName("명령어가 R이나 Q가 아니면 예외가 발생한다. (다른 문자)")
    @Test
    void createBridgeCommandByOther() {
        assertThatThrownBy(() -> new BridgeCommand("Z"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("명령어가 R이나 Q가 아니면 예외가 발생한다. (소문자)")
    @Test
    void createBridgeCommandByLowerCase() {
        assertThatThrownBy(() -> new BridgeCommand("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("명령어가 R이면 true를, Q이면 false를 리턴한다.")
    @Test
    void testBridgeCommandGetRetry() {
        assertThat(new BridgeCommand("R").getIsRetry()).isEqualTo(true);
        assertThat(new BridgeCommand("Q").getIsRetry()).isEqualTo(false);
    }
}

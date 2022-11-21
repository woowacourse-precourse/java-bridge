package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.game.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("다리의 길이가 3 ~ 20 이외의 숫자를 입력된 경우에 예외를 발생한다.")
    @Test
    void createBridgeByOverSize() {
        assertThatThrownBy(() -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 수를 입력 받은 경우 다리를 랜덤으로 생성한다.")
    @Test
    void createBridge() {
        assertThat(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(5).size()).isEqualTo(5);
    }
}

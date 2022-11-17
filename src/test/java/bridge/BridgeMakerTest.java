package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker( () -> new BridgeRandomNumberGenerator().generate());

    @DisplayName("사용자가 입력한 사이즈와 다리의 길이가 일치하는가")
    @Test
    void check_BridgeSize() {
        int size = 3;

        assertThat(bridgeMaker.makeBridge(size).size())
                .isEqualTo(3);
    }

    @DisplayName("다리가 U나 D로 구성되어 있는가")
    @Test
    void check_BridgeContainsOnlyUD() {
        int size = 10;

        assertThat(bridgeMaker.makeBridge(size))
                .as("[U 혹은 D]")
                .contains("U","D");
    }

    @DisplayName("0이 전달되면 예외가 발생되는가")
    @Test
    void check_Exception() {
        int size = 0;

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalStateException.class);
    }

}

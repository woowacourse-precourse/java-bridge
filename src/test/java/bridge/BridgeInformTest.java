package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeInformTest {
    @DisplayName("다리 길이가 올바른 범위에 있지 않으면 예외처리한다.")
    @Test
    void createBridgeInformOverSize() {
        assertThatThrownBy(() -> new BridgeInform(2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BridgeInform(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라운드마다 이동할 칸을 입력받고 유효하지 않으면 예외처리한다.")
    @Test
    void createBridgeInformDirection() {
        assertThatThrownBy(() -> new BridgeInform(3).setDirection("a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BridgeInform(3).setDirection("Op"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("종료할 문자열을 입력받고 유효하지 않으면 예외처리한다.")
    @Test
    void createBridgeInformExit() {
        assertThatThrownBy(() -> new BridgeInform(3).setExit("q"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BridgeInform(3).setExit("AB"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

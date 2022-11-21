package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMarkTest {

    @DisplayName("U가 주어질 때 BridgeMark 생성")
    @Test
    void createBridgeMark() {
        BridgeMark markUp = BridgeMark.of("U");
        BridgeMark markDown = BridgeMark.of("D");
        assertThat(markUp.isUp()).isTrue();
        assertThat(markDown.isDown()).isTrue();
    }

    @DisplayName("U, D 이외의 입력 값으로 BridgeMark 생성 시 예외 발생")
    @Test
    void createBridgeInvalidInput() {
        assertThatThrownBy(() -> BridgeMark.of("e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸의 입력의 경우 U와 D 뿐이어야 합니다.");
    }
}

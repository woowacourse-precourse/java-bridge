package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("여러개의 U, D가 주어질 때 BridgeMarks 생성")
    @Test
    void createBridges() {
        List<BridgeMark> bridges = BridgeMark.of(List.of("U", "U", "D"));
        assertThat(bridges).containsExactly(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("BridgeMark U, D 이외의 입력 값 검증 시 예외 발생")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> BridgeMark.validateInput("s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸의 입력의 경우 U와 D 뿐이어야 합니다.");
    }

    @DisplayName("BridgeMark가 업인지 다운인지 묻는 메소드 검증")
    @Test
    void isUpAndIsDown() {
        BridgeMark upMark = BridgeMark.UP;
        BridgeMark downMark = BridgeMark.DOWN;
        assertThat(upMark.isUp()).isTrue();
        assertThat(downMark.isDown()).isTrue();
    }

    @DisplayName("BridgeMark가 가지고 있는 필드 값 검증")
    @Test
    void getMark() {
        BridgeMark upMark = BridgeMark.UP;
        BridgeMark downMark = BridgeMark.DOWN;
        assertThat(upMark.getMark()).isEqualTo("U");
        assertThat(downMark.getMark()).isEqualTo("D");
    }
}

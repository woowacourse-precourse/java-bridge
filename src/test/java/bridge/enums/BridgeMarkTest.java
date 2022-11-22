package bridge.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMarkTest {

    @DisplayName("U, D가 주어질 때 BridgeMark 생성")
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

    @DisplayName("여러 개의 U, D가 주어질 때 BridgeMarks 생성")
    @Test
    void createBridges() {
        List<BridgeMark> bridges = BridgeMark.of(List.of("U", "U", "D"));
        assertThat(bridges).containsExactly(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("U, D 이외의 입력 값 검증 시 예외 발생")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> BridgeMark.validateInput("s"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸의 입력의 경우 U와 D 뿐이어야 합니다.");
    }

    @DisplayName("1, 0이 주어지면 U, D로 변환")
    @CsvSource(value = {"1,U", "0,D"})
    @ParameterizedTest
    void mapToString(int number, String result) {
        String mark = BridgeMark.mapToString(number);
        assertThat(mark).isEqualTo(result);
    }

    @DisplayName("다리의 숫자 값이 1 or 0 이외의 숫자일 경우 예외 발생")
    @Test
    void mapToStringInvalidInput() {
        assertThatThrownBy(() -> BridgeMark.mapToString(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 숫자 값은 1 or 0만 가능합니다.");
    }

    @DisplayName("BridgeMark가 업인지 다운인지 묻는 메소드 검증")
    @Test
    void isUpAndIsDown() {
        BridgeMark upMark = BridgeMark.UP;
        BridgeMark downMark = BridgeMark.DOWN;
        assertThat(upMark.isUp()).isTrue();
        assertThat(downMark.isDown()).isTrue();
    }

    @DisplayName("가지고 있는 필드 값 검증")
    @Test
    void getMark() {
        BridgeMark upMark = BridgeMark.UP;
        BridgeMark downMark = BridgeMark.DOWN;
        assertThat(upMark.getMark()).isEqualTo("U");
        assertThat(downMark.getMark()).isEqualTo("D");
    }
}

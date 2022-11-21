package bridge.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OneSideTest {

    @DisplayName("건너지 않은 칸에 공백을 추가한다.")
    @Test
    void addBlank() {
        OneSide oneSide = new OneSide();
        oneSide.addBlank();

        assertThat(oneSide.toString()).isEqualTo("  ");
    }

    @DisplayName("건널 수 있는 칸인지 여부에 따라 O 또는 X를 추가한다.")
    @Test
    void addRightOrWrong() {
        OneSide oneSideRight = new OneSide();
        OneSide oneSideWrong = new OneSide();
        oneSideRight.addRightOrWrong(true);
        oneSideWrong.addRightOrWrong(false);

        assertThat(oneSideRight.toString()).isEqualTo("O ");
        assertThat(oneSideWrong.toString()).isEqualTo("X ");
    }
}
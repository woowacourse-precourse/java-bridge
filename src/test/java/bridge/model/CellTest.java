package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellTest {

    @DisplayName("올바른 셀은 O를 반환한다.")
    @Test
    void correctCell() {
        //given
        Cell cell = Cell.CORRECT;
        String type = "O";

        //when
        String result = cell.getType();

        //then
        assertThat(result).isEqualTo(type);
    }

    @DisplayName("잘못된 셀은 X를 반환한다.")
    @Test
    void wrongCell() {
        //given
        Cell cell = Cell.WRONG;
        String type = "X";

        //when
        String result = cell.getType();

        //then
        assertThat(result).isEqualTo(type);
    }

    @DisplayName("공백 셀은 한 칸 공백을 반환한다.")
    @Test
    void blankCell() {
        //given
        Cell cell = Cell.BLANK;
        String type = " ";

        //when
        String result = cell.getType();

        //then
        assertThat(result).isEqualTo(type);
    }

}
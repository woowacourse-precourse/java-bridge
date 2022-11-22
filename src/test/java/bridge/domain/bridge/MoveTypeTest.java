package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MoveTypeTest {


    @Test
    @DisplayName("U,D 가 아닌 다른 값을 입력하면 예외 발생")
    public void 예외테스트() {
        //given
        //when
        //then
        assertThatThrownBy(() -> MoveType.create("u"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U 또는 D 를 입력해야 합니다.");
    }
}
package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("코드로 첫 글자 변환 테스트")
    @Test
    void getFirstLetter() {
        assertThat(Direction.getFirstLetter(1)).isEqualTo("U");
        assertThat(Direction.getFirstLetter(0)).isEqualTo("D");
    }

    @DisplayName("첫글자로 Direction 변환 테스트")
    @Test
    void getDirection() {
        assertThat(Direction.getDirection("U")).isEqualTo(Direction.UP);
        assertThat(Direction.getDirection("D")).isEqualTo(Direction.DOWN);
    }
}
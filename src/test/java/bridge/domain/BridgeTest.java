package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    private Bridge bridge;

    @DisplayName("다리 길이가 3 ~ 20이 아닐 경우 예외가 발생한다.")
    @Test
    void makeWrongSize() {
        assertThatThrownBy(() -> new Bridge(List.of("D", "D")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("건널 수 있는 칸인지 확인한다.")
    @CsvSource(value = {
            "0, D, true",
            "0, U, false",
            "1, D, false",
            "1, U, true",
            "2, D, false",
            "2, U, true"})
    @ParameterizedTest
    void checkMobility(int play, String moving, boolean expected) {
        boolean actual = bridge.canMove(play, moving);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다리의 길이를 구한다.")
    @Test
    void getBridgeSize() {
        int actual = bridge.getSize();
        assertThat(actual).isEqualTo(3);
    }
}

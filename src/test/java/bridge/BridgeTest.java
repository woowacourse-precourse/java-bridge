package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    private final Bridge bridge = new Bridge(List.of("D", "U", "U"));

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
        boolean actual = bridge.isPossibleMoving(play, moving);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("다리의 길이를 구한다.")
    @Test
    void getBridgeSize() {
        int actual = bridge.getSize();
        assertThat(actual).isEqualTo(3);
    }
}

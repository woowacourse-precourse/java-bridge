package bridge;

import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {
    @DisplayName("UP, DOWN에 해당하는 숫자를 문자열로 변경한다.")
    @ParameterizedTest
    @CsvSource({"1,U", "0,D"})
    public void changeDirectionNumberToDirection(int directionNumber, String direction) {
        String result = Direction.directionNumberToDirection(directionNumber);
        assertThat(result).isEqualTo(direction);
    }
}
package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {
    @DisplayName("UP, DOWN에 해당하는 숫자를 문자열로 변경한다.")
    @ParameterizedTest(name = "{displayName} => {0}, {1}")
    @CsvSource({"1,U", "0,D"})
    public void changeDirectionNumberToDirection(int directionNumber, String direction) {
        String result = Direction.directionNumberToDirection(directionNumber);
        assertThat(result).isEqualTo(direction);
    }

    @DisplayName("UP에 해당하는 값인 U인지 확인한다.")
    @ParameterizedTest(name = "{displayName} => {0}, {1}")
    @CsvSource({"U,true", "D,false"})
    public void checkDirectionIsUp(String direction, boolean expected) {
        assertThat(Direction.isUp(direction)).isEqualTo(expected);
    }
}
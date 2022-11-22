package bridge.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("방향 도메인 로직 테스트")
public class DirectionTest {

    @DisplayName("방향의 이니셜이 제대로 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"UP:U", "DOWN:D"}, delimiter = ':')
    void checkGetDirectionInitial(Direction direction, String expectedInitial) {
        assertThat(direction.getInitial()).isEqualTo(expectedInitial);
    }

    @DisplayName("숫자가 제대로 방향의 이니셜로 변환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    void checkGetDirectionInitialByNumber(int bridgeNumber, String expectedInitial) {
        String initial = Direction.getInitial(bridgeNumber);
        assertThat(initial).isEqualTo(expectedInitial);
    }

    @DisplayName("방향의 이니셜을 받았을 때 방향이 제대로 반환되는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:UP", "D:DOWN"}, delimiter = ':')
    void checkGetDirectionByInitial(String direction, Direction expectedDirection) {
        assertThat(Direction.of(direction)).isEqualTo(expectedDirection);
    }
}

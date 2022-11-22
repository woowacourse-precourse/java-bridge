package bridge;

import bridge.position.Latitude;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LatitudeTest {

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("필드 값을 갖는 enum 객체가 존재하는 경우 true 를 반환하는지 확인한다.")
    void contains(String direction) {
        Assertions.assertThat(Latitude.contains(direction)).isEqualTo(true);
    }

    @Test
    @DisplayName("필드 값을 갖는 enum 객체가 없는 경우 false 를 반환하는지 확인한다.")
    void containsByInvalidDirection() {
        String direction = "L";
        Assertions.assertThat(Latitude.contains(direction)).isEqualTo(false);
    }
}

package bridge;

import bridge.position.Latitude;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

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

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("필드 값으로 enum 객체를 조회했을 때 enum 객체가 반환되는지 확인한다.")
    void valueOfDirection(String direction) {
        Map<String, Latitude> map = new HashMap<>();
        map.put("U", Latitude.UP);
        map.put("D", Latitude.DOWN);
        Assertions.assertThat(Latitude.valueOfDirection(direction)).isEqualTo(map.get(direction));
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "K"})
    @DisplayName("필드 값으로 enum 객체 조회에 실패했을 때 null 이 반환되는지 확인한다.")
    void valueOfInvalidDirection(String direction) {
        Assertions.assertThat(Latitude.valueOfDirection(direction)).isEqualTo(null);
    }
}

package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapMakerTest {
    private final MapMaker testMapMaker = new MapMaker();

    @DisplayName("건너는데 성공한 지도를 반환한다.")
    @Test
    void makeMapSuccessTest() {
        String map = testMapMaker.makeMap(List.of("U", "D", "D"), false);
        assertThat(map).isEqualTo("[ O |   |   ]\n[   | O | O ]\n");
    }

    @DisplayName("건너는데 실패한 지도를 반환한다.")
    @Test
    void makeMapFailTest() {
        String map = testMapMaker.makeMap(List.of("U", "D", "U"), true);
        assertThat(map).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }

}

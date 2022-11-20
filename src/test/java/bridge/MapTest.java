package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    @DisplayName("맵 생성이 잘 되는지 확인한다.")
    @Test
    void testMapInitialize() {
        Map map = new Map();

        assertThat(map.getMap()).containsExactly("[ ", "[ ");
    }
}

package bridge.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapConverterTest {

    @DisplayName("누적 이동 결과를 지정된 포맷의 map 으로 변경한다")
    @Test
    void convertListToMap() {
        List<String> bridge = List.of(" ", "O", "X");
        String result = "[   | O | X ]";

        assertThat(MapConverter.convertToMap(bridge)).isEqualTo(result);
    }
}
